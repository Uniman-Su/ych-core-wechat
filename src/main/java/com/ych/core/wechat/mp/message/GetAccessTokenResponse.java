package com.ych.core.wechat.mp.message;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ych.core.fasterxml.jackson.databind.deser.UnixTimestampExpiresInDeserializer;

/**
 * 获取AccessToken的响应
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAccessTokenResponse extends MPResponse {

    /**
     * ACCESS TOKEN
     */
    @JsonProperty("access_token")
    private String accessToken;

    /**
     * 过期时间
     */
    @JsonDeserialize(using = UnixTimestampExpiresInDeserializer.class)
    @JsonProperty("expires_in")
    private Date expires;

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
}
