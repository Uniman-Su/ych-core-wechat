package com.ych.core.wechat.mp.authorization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 请求用户信息的响应
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoResponse extends AuthorizationUserInfo {

    private static final long serialVersionUID = 1965862360587337575L;

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
}
