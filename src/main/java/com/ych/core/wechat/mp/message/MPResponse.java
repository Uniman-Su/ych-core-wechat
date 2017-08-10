package com.ych.core.wechat.mp.message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 公众平台的请求响应
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MPResponse {

    /**
     * 平台返回的错误码
     */
    @JsonProperty("errcode")
    private String errorCode;

    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    private String errorMsg;

    /**
     * @return 平台返回的错误码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode
     *         平台返回的错误码
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

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
