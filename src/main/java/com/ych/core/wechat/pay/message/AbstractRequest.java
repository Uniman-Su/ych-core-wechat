package com.ych.core.wechat.pay.message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 抽象的请求
 */
@JacksonXmlRootElement(localName = "xml")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractRequest {

    /**
     * 随机字符串
     */
    @JsonProperty("nonce_str")
    private String nonceStr;

    /**
     * 签名
     */
    @JsonProperty("sign")
    private String sign;

    /**
     * 签名类型
     */
    @JsonProperty("sign_type")
    private String signType;

    /**
     * @return 随机字符串
     */
    public String getNonceStr() {
        return nonceStr;
    }

    /**
     * @param nonceStr
     *         随机字符串
     */
    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    /**
     * @return 签名
     */
    public String getSign() {
        return sign;
    }

    /**
     * @param sign
     *         签名
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * @return 签名类型
     */
    public String getSignType() {
        return signType;
    }

    /**
     * @param signType
     *         签名类型
     */
    public void setSignType(String signType) {
        this.signType = signType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
