package com.ych.core.wechat.mp.authorization;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ych.core.fasterxml.jackson.databind.deser.UnixTimestampExpiresInDeserializer;

/**
 * 用户AccessToken响应
 * <p>
 * Created by U on 2017/7/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccessTokenResponse extends UserAccessTokenInfo {

    private static final long serialVersionUID = -7465207228481164400L;

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
     * 默认构造方法
     */
    public UserAccessTokenResponse() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, Constants.REFRESH_TOKEN_EXPIRES_IN_DAY);
        setRefreshTokenExpires(calendar.getTime());
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

    @JsonProperty("openid")
    @Override
    public void setOpenId(String openId) {
        super.setOpenId(openId);
    }

    @JsonProperty("access_token")
    @Override
    public void setAccessToken(String accessToken) {
        super.setAccessToken(accessToken);
    }

    @JsonDeserialize(using = UnixTimestampExpiresInDeserializer.class)
    @JsonProperty("expires_in")
    @Override
    public void setAccessTokenExpires(Date accessTokenExpires) {
        super.setAccessTokenExpires(accessTokenExpires);
    }

    @JsonProperty("refresh_token")
    @Override
    public void setRefreshToken(String refreshToken) {
        super.setRefreshToken(refreshToken);
    }

    @Override
    public void setScope(AuthorizationScope scope) {
        super.setScope(scope);
    }

}
