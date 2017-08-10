package com.ych.core.wechat.mp;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ych.core.fasterxml.jackson.databind.deser.UnixTimestampExpiresInDeserializer;

/**
 * AccessToken信息
 */
public class AccessTokenInfo implements Serializable {

    private static final long serialVersionUID = 3255444837094652042L;

    /**
     * 错误码
     */
    @JsonProperty("errcode")
    private String errorCode;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    private String errorMsg;

    /**
     * ACCESS TOKEN
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 过期时间
     */
    @JsonProperty("expires_in")
    @JsonDeserialize(using = UnixTimestampExpiresInDeserializer.class)
    private Date expires;

    /**
     * 默认构造方法
     */
    public AccessTokenInfo() {
    }

    /**
     * 构造方法
     *
     * @param accessToken
     *         ACCESS TOKEN
     * @param expires
     *         过期时间
     */
    public AccessTokenInfo(String accessToken, Date expires) {
        this.accessToken = accessToken;
        this.expires = expires;
    }

    /**
     * @return 错误码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *         错误码
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return 错误消息
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg
     *         错误消息
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return ACCESS
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken
     *         ACCESS
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return 过期时间
     */
    public Date getExpires() {
        return expires;
    }

    /**
     * @param expires
     *         过期时间
     */
    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
