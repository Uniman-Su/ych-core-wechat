package com.ych.core.wechat.pay;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.ych.core.model.CommonOperationResult;
import com.ych.core.model.CommonOperationResultWidthData;
import com.ych.core.model.SystemParameterHolder;
import com.ych.core.pay.ChannelOperationResult;
import com.ych.core.pay.ChannelOperationResultImpl;
import com.ych.core.pay.CreatePayOrderParameter;
import com.ych.core.pay.PaymentStrategy;
import com.ych.core.wechat.pay.message.*;

/**
 * 微信的支付策略
 */
public abstract class WXPaymentStrategy implements PaymentStrategy {

    private static final Logger logger = LoggerFactory.getLogger(WXPaymentStrategy.class);

    /**
     * 附加数据属性名称
     */
    public static String EXTPARAM_ATTACH = "Attach";

    /**
     * 客户端IP属性名称
     */
    public static String EXTPARAM_TERMINAL_IP = "TerminalIP";

    /**
     * 回调通知URL属性名称
     */
    public static String EXTPARAM_NOTIFY_URL = "NotifyURL";

    /**
     * 交易类型属性名称
     */
    public static String EXTPARAM_TRADE_TYPE = "TradeType";

    /**
     * 限制支付属性名称
     */
    public static String EXTPARAM_LIMIT_PAY = "LimitPay";

    /**
     * OpenId属性名称
     */
    public static String EXTPARAM_OPEN_ID = "OpenID";

    /**
     * 场景信息属性名称
     */
    public static String EXTPARAM_SCENE_INFO = "SceneInfo";

    /**
     * 标价币种属性名称
     */
    public static String EXTPARAM_FEE_TYPE = "FeeType";

    /**
     * 订单金额属性名称
     */
    public static String EXTPARAM_TOTAL_FEE = "TotalFee";

    /**
     * 退款金额属性名称
     */
    public static String EXTPARAM_REFUND_FEE = "RefundFee";

    /**
     * 货币种类属性名称
     */
    public static String EXTPARAM_REFUND_FEE_TYPE = "RefundFeeType";

    /**
     * 退款原因属性名称
     */
    public static String EXTPARAM_REFUND_DESC = "RefundDesc";

    /**
     * 退款资金来源
     */
    public static String EXTPARAM_REFUND_ACCOUNT = "RefundAccount";

    /**
     * 返回的对象属性名称
     */
    public static String EXTPARAM_RESP_OBJ = "ResponseObject";

    /**
     * 微信支付工具
     */
    private WXPayUtils wxPayUtils;

    /**
     * 微信AppId
     */
    private SystemParameterHolder wxAppId;

    /**
     * 微信支付商户ID
     */
    private SystemParameterHolder wxPayMerchantId;

    @Autowired
    private MessageSource messageSource;

    /**
     * @param wxPayUtils
     *         微信支付工具
     */
    public void setWxPayUtils(WXPayUtils wxPayUtils) {
        this.wxPayUtils = wxPayUtils;
    }

    /**
     * @param wxAppId
     *         微信AppId
     */
    public void setWxAppId(SystemParameterHolder wxAppId) {
        this.wxAppId = wxAppId;
    }

    /**
     * @param wxPayMerchantId
     *         微信支付商户ID
     */
    public void setWxPayMerchantId(SystemParameterHolder wxPayMerchantId) {
        this.wxPayMerchantId = wxPayMerchantId;
    }

    private boolean isSupport(String channelName) {
        for (String name : getSupportChannelNames()) {
            if (name.equals(channelName)) {
                return true;
            }
        }

        return false;
    }

    private CommonOperationResultWidthData<ChannelOperationResult> checkChannelSupport(String channelName, String flowNo) {
        CommonOperationResultWidthData<ChannelOperationResult> ret = new CommonOperationResultWidthData<>();

        if (isSupport(channelName)) {
            ret.setResult(CommonOperationResult.Succeeded);
        } else {
            ChannelOperationResultImpl operationResult = new ChannelOperationResultImpl();
            operationResult.setFlowNo(flowNo);
            ret.setResult(CommonOperationResult.IllegalArguments);
            ret.setData(operationResult);
            return ret;
        }

        return ret;
    }

    private void fillResult(CommonOperationResultWidthData<ChannelOperationResult> ret, String flowNo, ReturnResult response) {
        ChannelOperationResultImpl operationResult = new ChannelOperationResultImpl();
        operationResult.setFlowNo(flowNo);

        HashMap<String, Object> retExtendedParameters = new HashMap<>();
        retExtendedParameters.put(EXTPARAM_RESP_OBJ, response);
        operationResult.setExtendedParameters(retExtendedParameters);

        ret.setData(operationResult);

        if (ErrorCode.SUCCESS.equals(response.getReturnCode()) && ErrorCode.SUCCESS.equals(response.getResultCode())) {
            ret.setResult(CommonOperationResult.Succeeded);
            operationResult.setErrorMsg(response.getReturnCode());
        } else {
            if (!ErrorCode.SUCCESS.equals(response.getReturnCode())) {
                operationResult.setErrorCode(response.getReturnCode());
                operationResult.setErrorMsg(response.getReturnMsg());
                ret.setDescription(response.getReturnMsg());
            } else {
                operationResult.setErrorCode(response.getErrorCode());
                operationResult.setErrorMsg(response.getErrorCodeDesc());
                ret.setDescription(response.getErrorCodeDesc());
            }
            ret.setResult(CommonOperationResult.Failed);
        }
    }

    @Override
    public CommonOperationResultWidthData<ChannelOperationResult> createPayOrder(CreatePayOrderParameter parameter, Map<String, Object> extendedParamters) {
        CommonOperationResultWidthData<ChannelOperationResult> ret;

        ret = checkChannelSupport(parameter.getChannelName(), parameter.getFlowNo());
        if (ret.getResult() != CommonOperationResult.Succeeded) {
            return ret;
        }

        UnifiedOrderRequest request = new UnifiedOrderRequest();
        request.setAppId(wxAppId.getStringValue());
        request.setMerchantId(wxPayMerchantId.getStringValue());
        request.setBody(parameter.getOrderSubject());
        request.setDetail(parameter.getOrderDesc());
        request.setAttach((String) extendedParamters.get(EXTPARAM_ATTACH));
        request.setOutTradeNo(parameter.getFlowNo());
        request.setFeeType((String) extendedParamters.get(EXTPARAM_FEE_TYPE));
        request.setTotalFee(parameter.getTotalMoney().multiply(BigDecimal.valueOf(100)).intValue());
        request.setTerminalIp((String) extendedParamters.get(EXTPARAM_TERMINAL_IP));

        if (parameter.getTimeout() != null) {
            request.setExpires(new Date(System.currentTimeMillis() + parameter.getTimeout()));
        }

        request.setNotifyUrl((String) extendedParamters.get(EXTPARAM_NOTIFY_URL));
        request.setTradeType((TradeType) extendedParamters.get(EXTPARAM_TRADE_TYPE));
        request.setLimitPay((String) extendedParamters.get(EXTPARAM_LIMIT_PAY));
        request.setOpenId((String) extendedParamters.get(EXTPARAM_OPEN_ID));
        request.setSceneInfo((SceneInfo) extendedParamters.get(EXTPARAM_SCENE_INFO));

        UnifiedOrderResponse response;

        try {
            response = wxPayUtils.createUnifiedOrder(request);
        } catch (Exception e) {
            logger.error("Create WXPay order failed", e);
            ChannelOperationResultImpl operationResult = new ChannelOperationResultImpl();
            operationResult.setFlowNo(parameter.getFlowNo());
            ret.setResult(CommonOperationResult.RemoteRequestFailed);
            ret.setData(operationResult);
            return ret;
        }

        fillResult(ret, parameter.getFlowNo(), response);
        ((ChannelOperationResultImpl) ret.getData()).setPrepayChannelFlowNo(response.getPrepayId());

        return ret;
    }

    @Override
    public CommonOperationResultWidthData<ChannelOperationResult> cancelPayOrder(String channelName, String orderNo, String channelOrderNo, Map<String, Object> extendedParamters) {
        CommonOperationResultWidthData<ChannelOperationResult> ret;

        ret = checkChannelSupport(channelName, orderNo);
        if (ret.getResult() != CommonOperationResult.Succeeded) {
            return ret;
        }

        CloseOrderRequest request = new CloseOrderRequest();
        request.setAppId(wxAppId.getStringValue());
        request.setMerchantId(wxPayMerchantId.getStringValue());
        request.setOutTradeNo(orderNo);

        CloseOrderResponse response;

        try {
            response = wxPayUtils.closeOrder(request);
        } catch (Exception e) {
            logger.error("Close WXPay order failed", e);
            ChannelOperationResultImpl operationResult = new ChannelOperationResultImpl();
            operationResult.setFlowNo(orderNo);
            ret.setResult(CommonOperationResult.RemoteRequestFailed);
            ret.setData(operationResult);
            return ret;
        }

        fillResult(ret, orderNo, response);

        return ret;
    }

    @Override
    public CommonOperationResultWidthData<ChannelOperationResult> refund(String channelName, String orderNo, String refundNo, String channelOrderNo, String channelRefundNo, Map<String, Object> extendedParamters) {
        CommonOperationResultWidthData<ChannelOperationResult> ret;

        ret = checkChannelSupport(channelName, orderNo);
        if (ret.getResult() != CommonOperationResult.Succeeded) {
            return ret;
        }

        RefundRequest request = new RefundRequest();
        request.setAppId(wxAppId.getStringValue());
        request.setMerchantId(wxPayMerchantId.getStringValue());
        request.setTransactionId(channelOrderNo);
        request.setOutTradeNo(orderNo);
        request.setOutRefundNo(refundNo);
        request.setTotalFee(((BigDecimal) extendedParamters.get(EXTPARAM_TOTAL_FEE)).multiply(BigDecimal.valueOf(100)).intValue());
        request.setRefundFee(((BigDecimal) extendedParamters.get(EXTPARAM_REFUND_FEE)).multiply(BigDecimal.valueOf(100)).intValue());
        request.setRefundFeeType((String) extendedParamters.get(EXTPARAM_REFUND_FEE_TYPE));
        request.setRefundDesc((String) extendedParamters.get(EXTPARAM_REFUND_DESC));
        request.setRefundAccount((String) extendedParamters.get(EXTPARAM_REFUND_ACCOUNT));

        RefundResponse response;

        try {
            response = wxPayUtils.refund(request);
        } catch (Exception e) {
            logger.error("Refund WXPay order failed", e);
            ChannelOperationResultImpl operationResult = new ChannelOperationResultImpl();
            operationResult.setFlowNo(orderNo);
            ret.setResult(CommonOperationResult.RemoteRequestFailed);
            ret.setDescription(messageSource.getMessage("system.common.RemoteRequestFailed", null, Locale.getDefault()));
            ret.setData(operationResult);
            return ret;
        }

        fillResult(ret, orderNo, response);
        ((ChannelOperationResultImpl) ret.getData()).setChannelFlowNo(response.getRefundId());

        return ret;
    }

    @Override
    public boolean isGenerateRefundNo(String channelName) {
        return false;
    }

}
