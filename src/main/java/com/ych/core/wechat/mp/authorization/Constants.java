package com.ych.core.wechat.mp.authorization;

/**
 * 常量
 * <p>
 * Created by U on 2017/7/17.
 */
public interface Constants extends com.ych.core.wechat.Constants {

    /**
     * 获取授权的URL
     */
    String AUTHORIZATION_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type={2}&scope={3}&state={4}#wechat_redirect";

    /**
     * 获取用户AccessToken的URL
     */
    String GET_USER_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type={grant_type}";

    /**
     * 通过授权接口获取用户信息的URL
     */
    String GET_AUTH_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token={accessToken}&openid={openId}&lang={locale}";

    /**
     * RefreshToken的过期时长
     */
    int REFRESH_TOKEN_EXPIRES_IN_DAY = 30;

}
