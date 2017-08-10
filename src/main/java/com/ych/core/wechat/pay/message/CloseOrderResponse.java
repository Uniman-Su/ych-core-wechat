package com.ych.core.wechat.pay.message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.ych.core.wechat.pay.TradeType;

/**
 * 关闭订单响应报文
 * <p>
 * Created by U on 2017/7/19.
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CloseOrderResponse extends ReturnResult {

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
     * 微信返回的随机字符串
     */
    @JsonProperty("nonce_str")
    private String nonceStr;

    /**
     * 微信返回的签名值
     */
    private String sign;

    /**
     * 业务结果描述
     */
    @JsonProperty("result_msg")
    private String resultMsg;

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
     * @return 业务结果描述
     */
    public String getResultMsg() {
        return resultMsg;
    }

    /**
     * @param resultMsg
     *         业务结果描述
     */
    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

}
