package com.ych.core.wechat.mp;

/**
 * 常量
 */
public interface Constants extends com.ych.core.wechat.Constants {

    /**
     * 成功的错误码
     */
    String SUCCESS = "0";

    /**
     * 获取AccessToken的URL
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appId}&secret={appSecret}";

    /**
     * 获取用户信息的URL
     */
    String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={accessToken}&openid={openId}&lang={locale}";

    /**
     * 获取JS API Ticket的URL
     */
    String GET_JS_API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={accessToken}&type=jsapi";

    /**
     * 创建菜单URL
     */
    String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={accessToken}";

    /**
     * 删除自定义菜单URL
     */
    String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token={accessToken}";

}
