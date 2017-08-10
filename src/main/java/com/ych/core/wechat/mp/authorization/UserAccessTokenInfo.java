package com.ych.core.wechat.mp.authorization;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户的AccessToken信息
 * <p>
 * Created by U on 2017/7/17.
 */
public class UserAccessTokenInfo implements Serializable {

    private static final long serialVersionUID = 4592934302330412203L;

    /**
     * OpenID
     */
    private String openId;

    /**
     * AccessToken
     */
    private String accessToken;

    /**
     * AccessToken过期时间
     */
    private Date accessTokenExpires;

    /**
     * RefreshToken
     */
    private String refreshToken;

    /**
     * RefreshToken过期时间
     */
    private Date refreshTokenExpires;

    /**
     * 作用域
     */
    private AuthorizationScope scope;

    /**
     * @return OpenID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     *         OpenID
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return AccessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken
     *         AccessToken
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return AccessToken过期时间
     */
    public Date getAccessTokenExpires() {
        return accessTokenExpires;
    }

    /**
     * @param accessTokenExpires
     *         AccessToken过期时间
     */
    public void setAccessTokenExpires(Date accessTokenExpires) {
        this.accessTokenExpires = accessTokenExpires;
    }

    /**
     * @return RefreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * @param refreshToken
     *         RefreshToken
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * @return RefreshToken过期时间
     */
    public Date getRefreshTokenExpires() {
        return refreshTokenExpires;
    }

    /**
     * @param refreshTokenExpires
     *         RefreshToken过期时间
     */
    public void setRefreshTokenExpires(Date refreshTokenExpires) {
        this.refreshTokenExpires = refreshTokenExpires;
    }

    /**
     * @return 作用域
     */
    public AuthorizationScope getScope() {
        return scope;
    }

    /**
     * @param scope
     *         作用域
     */
    public void setScope(AuthorizationScope scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
