package com.ych.core.wechat.mp.authorization;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.ych.core.spring.web.client.Jackson2JsonOnlyResponseExtractor;
import com.ych.core.spring.web.client.RequestCallbackAdapter;
import com.ych.core.wechat.mp.UserInfo;

/**
 * 授权工具
 * <p>
 * Created by U on 2017/7/17.
 */
public class AuthorizationUtils {

    private Logger logger = LoggerFactory.getLogger(AuthorizationUtils.class);

    /**
     * Rest模板
     */
    private RestTemplate restTemplate;


    /**
     * @param restTemplate
     *         Rest模板
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 获取跳转授权页的URL
     *
     * @param appId
     *         AppID
     * @param redirectUrl
     *         回调URL
     * @param scope
     *         作用域
     * @param state
     *         回传的参数
     * @return 拼装好的URL
     */
    public String getAuthorizationUrl(String appId, String redirectUrl, AuthorizationScope scope, String state) {
        try {
            redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // can not happen
            logger.error("Encode URL failed", e);
        }

        state = StringUtils.trimToEmpty(state);

        return MessageFormat.format(Constants.AUTHORIZATION_URL, appId, redirectUrl, "code", scope, state);
    }

    /**
     * 获取用户的AccessToken信息
     *
     * @param appId
     *         AppId
     * @param appSecret
     *         AppSecret
     * @param code
     *         用户授权的Code
     * @return 用户访问信息
     */
    public UserAccessTokenInfo getUserAccessToken(String appId, String appSecret, String code) {
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("appid", appId);
        parameter.put("secret", appSecret);
        parameter.put("code", code);
        parameter.put("grant_type", "authorization_code");

        logger.info("Get user access token:{}", parameter);

        UserAccessTokenResponse response = restTemplate.execute(Constants.GET_USER_ACCESS_TOKEN_URL, HttpMethod.GET, RequestCallbackAdapter.DEFAULT, Jackson2JsonOnlyResponseExtractor.getInstance(UserAccessTokenResponse.class), parameter);

        if (StringUtils.isNotEmpty(response.getErrorCode())) {
            logger.warn("Get user AccessToken failed, {}[{}]", response.getErrorCode(), response.getErrorMsg());
            return null;
        }

        logger.info("Result:{}", response);

        return response;
    }

    /**
     * 获取用户信息
     *
     * @param accessToken
     *         AccessToken
     * @param openId
     *         OpenId
     * @param locale
     *         语言
     * @return 用户信息
     */
    public AuthorizationUserInfo getUserInf(String accessToken, String openId, Locale locale) {
        HashMap<String, Object> parameter = new HashMap<>();
        parameter.put("accessToken", accessToken);
        parameter.put("openId", openId);
        parameter.put("locale", locale);

        logger.info("Get user info:{}", parameter);


        UserInfoResponse response = restTemplate.execute(Constants.GET_AUTH_USER_INFO_URL, HttpMethod.GET, RequestCallbackAdapter.DEFAULT, Jackson2JsonOnlyResponseExtractor.getInstance(UserInfoResponse.class), parameter);

        if (StringUtils.isNotEmpty(response.getErrorCode())) {
            logger.warn("Get user info failed, {}[{}]", response.getErrorCode(), response.getErrorMsg());
            return null;
        }

        logger.info("Result:{}", response);

        return response;
    }


}
