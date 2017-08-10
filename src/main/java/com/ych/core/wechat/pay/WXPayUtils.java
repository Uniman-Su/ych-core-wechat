package com.ych.core.wechat.pay;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URI;
import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ych.core.fasterxml.jackson.MapperUtils;
import com.ych.core.model.SystemParameterHolder;
import com.ych.core.spring.web.client.Jackson2XmlOnlyResponseExtractor;
import com.ych.core.wechat.pay.message.*;

/**
 * 微信支付的工具
 * <p>
 * Created by U on 2017/7/19.
 */
public class WXPayUtils {

    private static final Logger logger = LoggerFactory.getLogger(WXPayUtils.class);

    private RestTemplate restTemplate;

    private RestTemplate secureRestTemplate;

    private SystemParameterHolder wxPaySecurityKey;

    private ObjectSerializer jsonSerializer = new ObjectSerializer() {
        @Override
        public String serialize(Object value) {
            try {
                return MapperUtils.MAPPER.get().writeValueAsString(value);
            } catch (JsonProcessingException e) {
                logger.error("Write JSON failed", e);
                return null;
            }
        }
    };

    private ObjectSerializer dateFormatSerializer = new ObjectSerializer() {
        @Override
        public String serialize(Object value) {
            return DateFormatUtils.format((Date) value , "yyyyMMddHHmmss", com.ych.core.wechat.Constants.WECHAT_SERVER_TIMEZONE);
        }
    };

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setSecureRestTemplate(RestTemplate secureRestTemplate) {
        this.secureRestTemplate = secureRestTemplate;
    }

    public void setWxPaySecurityKey(SystemParameterHolder wxPaySecurityKey) {
        this.wxPaySecurityKey = wxPaySecurityKey;
    }

    private void addSignEntry(String name, Object value, SortedMap<String, String> sortedMap, ObjectSerializer serializer) {
        if (value != null) {
            if (value instanceof String) {
                if (StringUtils.isNotEmpty((String) value)) {
                    sortedMap.put(name, (String) value);
                }
            } else {
                sortedMap.put(name, serializer == null ? String.valueOf(value) : serializer.serialize(value));
            }
        }
    }

    private void addSignEntry(String name, Object value, SortedMap<String, String> sortedMap) {
        addSignEntry(name, value, sortedMap, null);
    }

    /**
     * 获取数据签名
     *
     * @param sortedMap
     *         签名数据
     * @param signType
     *         签名类型
     * @return 签名的字符串
     */
    public String getSign(SortedMap<String, String> sortedMap, String signType) {
        StringBuilder buffer = new StringBuilder();

        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            buffer.append(entry.getKey());
            buffer.append('=');
            buffer.append(entry.getValue());
            buffer.append('&');
        }

        buffer.append("key=").append(wxPaySecurityKey.getStringValue());

        if (StringUtils.isEmpty(signType) || Constants.SIGN_TYPE_MD5.equals(signType)) {
            return DigestUtils.md5Hex(buffer.toString()).toUpperCase();
        } else if (Constants.SIGN_TYPE_SHA256.equals(signType)) {
            return DigestUtils.sha256Hex(buffer.toString()).toUpperCase();
        } else {
            throw new IllegalArgumentException("Illegal signType[" + signType + "]");
        }
    }

    /**
     * @return 随机字符串
     */
    public String getNonceStr() {
        return UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();
    }

    private String signUnifiedOrder(UnifiedOrderRequest request) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        addSignEntry("appid", request.getAppId(), sortedMap);
        addSignEntry("mch_id", request.getMerchantId(), sortedMap);
        addSignEntry("device_info", request.getDeviceInfo(), sortedMap);
        addSignEntry("nonce_str", request.getNonceStr(), sortedMap);
        addSignEntry("sign_type", request.getSignType(), sortedMap);
        addSignEntry("body", request.getBody(), sortedMap);
        addSignEntry("detail", request.getDetail(), sortedMap);
        addSignEntry("attach", request.getAttach(), sortedMap);
        addSignEntry("out_trade_no", request.getOutTradeNo(), sortedMap);
        addSignEntry("fee_type", request.getFeeType(), sortedMap);
        addSignEntry("total_fee", request.getTotalFee(), sortedMap);
        addSignEntry("spbill_create_ip", request.getTerminalIp(), sortedMap);
        addSignEntry("time_start", request.getStartTime(), sortedMap, dateFormatSerializer);
        addSignEntry("time_expire", request.getExpires(), sortedMap, dateFormatSerializer);
        addSignEntry("goods_tag", request.getGoodsTag(), sortedMap);
        addSignEntry("notify_url", request.getNotifyUrl(), sortedMap);
        addSignEntry("trade_type", request.getTradeType(), sortedMap);
        addSignEntry("product_id", request.getProductId(), sortedMap);
        addSignEntry("limit_pay", request.getLimitPay(), sortedMap);
        addSignEntry("openid", request.getOpenId(), sortedMap);
        addSignEntry("scene_info", request.getSceneInfo(), sortedMap, jsonSerializer);
        return getSign(sortedMap, request.getSignType());
    }

    private <T> T executeRequest(final AbstractRequest requestObject, URI uri, RestTemplate restTemplate, Class<T> responseType) {
        return restTemplate.execute(uri, HttpMethod.POST, new RequestCallback() {
            @Override
            public void doWithRequest(ClientHttpRequest request) throws IOException {
                request.getHeaders().setContentType(MediaType.APPLICATION_XML);
                Writer writer = new OutputStreamWriter(request.getBody(), "UTF-8");
                writer.write(MapperUtils.XML_MAPPER.get().writeValueAsString(requestObject));
                writer.flush();
            }
        }, Jackson2XmlOnlyResponseExtractor.getInstance(responseType));
    }

    /**
     * 创建统一订单
     *
     * @param request
     *         请求对象
     * @return 响应对象
     */
    public UnifiedOrderResponse createUnifiedOrder(UnifiedOrderRequest request) {
        request.setNonceStr(getNonceStr());
        request.setSign(signUnifiedOrder(request));
        return executeRequest(request, URI.create(Constants.CREATE_UNIFIED_ORDER_URL), restTemplate, UnifiedOrderResponse.class);
    }

    private String signPayNotify(PayNotify payNotify) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        addSignEntry("return_code", payNotify.getReturnCode(), sortedMap);
        addSignEntry("return_msg", payNotify.getReturnMsg(), sortedMap);
        addSignEntry("appid", payNotify.getAppId(), sortedMap);
        addSignEntry("mch_id", payNotify.getMerchantId(), sortedMap);
        addSignEntry("device_info", payNotify.getDeviceInfo(), sortedMap);
        addSignEntry("nonce_str", payNotify.getNonceStr(), sortedMap);
        addSignEntry("sign_type", payNotify.getSignType(), sortedMap);
        addSignEntry("result_code", payNotify.getResultCode(), sortedMap);
        addSignEntry("err_code", payNotify.getErrorCode(), sortedMap);
        addSignEntry("err_code_des", payNotify.getErrorCodeDesc(), sortedMap);
        addSignEntry("openid", payNotify.getOpenId(), sortedMap);
        addSignEntry("is_subscribe", payNotify.isSubscribe() ? "Y" : "N", sortedMap);
        addSignEntry("trade_type", payNotify.getTradeType(), sortedMap);
        addSignEntry("bank_type", payNotify.getBankType(), sortedMap);
        addSignEntry("total_fee", payNotify.getTotalFee(), sortedMap);
        addSignEntry("settlement_total_fee", payNotify.getSettlementTotalFee(), sortedMap);
        addSignEntry("fee_type", payNotify.getFeeType(), sortedMap);
        addSignEntry("cash_fee", payNotify.getCashFee(), sortedMap);
        addSignEntry("cash_fee_type", payNotify.getCashFeeType(), sortedMap);
        addSignEntry("transaction_id", payNotify.getTransactionId(), sortedMap);
        addSignEntry("out_trade_no", payNotify.getOutTradeNo(), sortedMap);
        addSignEntry("attach", payNotify.getAttach(), sortedMap);
        addSignEntry("time_end", payNotify.getPayTime(), sortedMap, dateFormatSerializer);
        return getSign(sortedMap, payNotify.getSignType());
    }

    /**
     * 对支付通知进行验签
     *
     * @param payNotify
     *         支付通知
     * @return 验签结果
     */
    public ReturnResult validatePayNotifySign(PayNotify payNotify) {
        ReturnResult ret = new ReturnResult();

        if (payNotify.getSign().equals(signPayNotify(payNotify))) {
            ret.setReturnCode(ErrorCode.SUCCESS);
        } else {
            ret.setReturnCode(ErrorCode.FAIL);
            ret.setReturnMsg("Validate sign failed");
        }

        return ret;
    }

    private String signOrderQuery(OrderQueryRequest request) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        addSignEntry("appid", request.getAppId(), sortedMap);
        addSignEntry("mch_id", request.getMerchantId(), sortedMap);
        addSignEntry("transaction_id", request.getTransactionId(), sortedMap);
        addSignEntry("out_trade_no", request.getOutTradeNo(), sortedMap);
        addSignEntry("nonce_str", request.getNonceStr(), sortedMap);
        addSignEntry("sign_type", request.getSignType(), sortedMap);
        return getSign(sortedMap, request.getSignType());
    }

    /**
     * 查询订单信息
     *
     * @param request
     *         请求
     * @return 响应
     */
    public OrderQueryResponse queryOrderInfo(OrderQueryRequest request) {
        request.setNonceStr(getNonceStr());
        request.setSign(signOrderQuery(request));

        return executeRequest(request, URI.create(Constants.QUERY_ORDER_URL), restTemplate, OrderQueryResponse.class);
    }

    /**
     * 关闭订单
     *
     * @param request
     *         请求
     * @return 响应
     */
    public CloseOrderResponse closeOrder(CloseOrderRequest request) {
        request.setNonceStr(getNonceStr());
        request.setSign(signOrderQuery(request));
        return executeRequest(request, URI.create(Constants.CLOSE_ORDER_URL), restTemplate, CloseOrderResponse.class);
    }

    private String signRefund(RefundRequest request) {
        TreeMap<String, String> sortedMap = new TreeMap<>();
        addSignEntry("appid", request.getAppId(), sortedMap);
        addSignEntry("mch_id", request.getMerchantId(), sortedMap);
        addSignEntry("nonce_str", request.getNonceStr(), sortedMap);
        addSignEntry("sign_type", request.getSignType(), sortedMap);
        addSignEntry("transaction_id", request.getTransactionId(), sortedMap);
        addSignEntry("out_trade_no", request.getOutTradeNo(), sortedMap);
        addSignEntry("out_refund_no", request.getOutRefundNo(), sortedMap);
        addSignEntry("total_fee", request.getTotalFee(), sortedMap);
        addSignEntry("refund_fee", request.getRefundFee(), sortedMap);
        addSignEntry("refund_fee_type", request.getRefundFeeType(), sortedMap);
        addSignEntry("refund_desc", request.getRefundDesc(), sortedMap);
        addSignEntry("refund_account", request.getRefundAccount(), sortedMap);
        return getSign(sortedMap, request.getSignType());
    }

    /**
     * 申请退款
     *
     * @param request
     *         请求
     * @return 响应
     */
    public RefundResponse refund(RefundRequest request) {
        request.setNonceStr(getNonceStr());
        request.setSign(signRefund(request));
        return executeRequest(request, URI.create(Constants.REFUND_URL), secureRestTemplate, RefundResponse.class);
    }

    interface ObjectSerializer {

        String serialize(Object value);

    }

}
