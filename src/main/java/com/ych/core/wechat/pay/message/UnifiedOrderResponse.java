package com.ych.core.wechat.pay.message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ych.core.wechat.pay.TradeType;

/**
 * 统一下单响应报文
 * <p>
 * Created by U on 2017/7/19.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnifiedOrderResponse extends ReturnResult {

    /**
     * 调用接口提交的公众账号ID
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 调用接口提交的商户号
     */
    @JsonProperty("mch_id")
    private String merchantId;

    /**
     * 自定义参数，可以为请求支付的终端设备号等
     */
    @JsonProperty("device_info")
    private String deviceInfo;

    /**
     * 微信返回的随机字符串
     */
    @JsonProperty("nonce_str")
    private String nonceStr;

    /**
     * 微信返回的签名值
     */
    private String sign;

    /**
     * 交易类型
     */
    @JsonProperty("trade_type")
    private TradeType tradeType;

    /**
     * 预支付交易会话标识
     */
    @JsonProperty("prepay_id")
    private String prepayId;

    /**
     * trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
     */
    @JsonProperty("code_url")
    private String codeUrl;

    /**
     * @return 调用接口提交的公众账号ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *         调用接口提交的公众账号ID
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return 调用接口提交的商户号
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     *         调用接口提交的商户号
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return 自定义参数，可以为请求支付的终端设备号等
     */
    public String getDeviceInfo() {
        return deviceInfo;
    }

    /**
     * @param deviceInfo
     *         自定义参数，可以为请求支付的终端设备号等
     */
    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    /**
     * @return 微信返回的随机字符串
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * @param nonceStr
     *         微信返回的随机字符串
     */
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    /**
     * @return 微信返回的签名值
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     *         微信返回的签名值
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return 交易类型
     */
    public TradeType getTradeType() {
        return tradeType;
    }

    /**
     * @param tradeType
     *         交易类型
     */
    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    /**
     * @return 预支付交易会话标识
     */
    public String getPrepayId() {
        return prepayId;
    }

    /**
     * @param prepayId
     *         预支付交易会话标识
     */
    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    /**
     * @return trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
     */
    public String getCodeUrl() {
        return codeUrl;
    }

    /**
     * @param codeUrl
     *         trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
     */
    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

}
