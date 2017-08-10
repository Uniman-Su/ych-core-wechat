package com.ych.core.wechat;

import java.util.TimeZone;

/**
 * 微信使用的常量
 *
 * Created by U on 2017/6/30.
 */
public interface Constants extends com.ych.core.Constants {

    /**
     * 微信服务器的时区
     */
    TimeZone WECHAT_SERVER_TIMEZONE = TimeZone.getTimeZone("Asia/Shanghai");

    /**
     * MD5签名方式
     */
    String SIGN_TYPE_MD5 = "MD5";

    /**
     * SHA256签名方式
     */
    String SIGN_TYPE_SHA256 = "HMAC-SHA256";

}
