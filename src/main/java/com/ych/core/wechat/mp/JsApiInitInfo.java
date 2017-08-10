package com.ych.core.wechat.mp;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * JsApi初始化信息
 */
public class JsApiInitInfo {

    /**
     * AppId
     */
    private String appId;

    /**
     * Unix时间戳
     */
    private long timestamp;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 签名
     */
    private String signature;

    public JsApiInitInfo() {
    }

    public JsApiInitInfo(String appId, long timestamp, String nonceStr, String signature) {
        this.appId = appId;
        this.timestamp = timestamp;
        this.nonceStr = nonceStr;
        this.signature = signature;
    }

    /**
     * @return AppId
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *         AppId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return Unix时间戳
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     *         Unix时间戳
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

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
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature
     *         签名
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
