package com.ych.core.wechat.mp;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 基础用户信息
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicUserInfo implements Serializable {

    private static final long serialVersionUID = -1532199121739578761L;

    /**
     * 用户OpenId
     */
    @JsonProperty("openid")
    private String openId;

    /**
     * 昵称
     */
    @JsonProperty("nickname")
    private String nickname;

    /**
     * 用户性别
     */
    private UserSex sex;

    /**
     * 用户所在城市
     */
    private String city;

    /**
     * 用户所在国家
     */
    private String country;

    /**
     * 用户所在省份
     */
    private String province;

    /**
     * 用户的语言，简体中文为zh_CN
     */
    private String language;

    /**
     * 用户头像
     */
    @JsonProperty("headimgurl")
    private String avatarUrl;

    /**
     * 用户的UnionID
     */
    @JsonProperty("unionid")
    private String unionId;

    /**
     * @return 用户OpenId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     *         用户OpenId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * @return 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     *         昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return 用户性别
     */
    public UserSex getSex() {
        return sex;
    }

    /**
     * @param sex
     *         用户性别
     */
    public void setSex(UserSex sex) {
        this.sex = sex;
    }

    /**
     * @return 用户所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *         用户所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return 用户所在国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     *         用户所在国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return 用户所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     *         用户所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return 用户的语言，简体中文为zh_CN
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language
     *         用户的语言，简体中文为zh_CN
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return 用户头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl
     *         用户头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return 用户的UnionID
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * @param unionId
     *         用户的UnionID
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
