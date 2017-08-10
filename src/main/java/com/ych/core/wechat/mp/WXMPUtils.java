package com.ych.core.wechat.mp;

import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.ych.core.model.BaseWithCommonOperationResult;
import com.ych.core.model.CommonOperationResult;
import com.ych.core.model.SystemParameterHolder;
import com.ych.core.spring.web.client.Jackson2JsonOnlyResponseExtractor;
import com.ych.core.spring.web.client.Jackson2JsonRequestCallback;
import com.ych.core.wechat.mp.message.CreateMenuRequest;
import com.ych.core.wechat.mp.message.MPResponse;

/**
 * 微信公众平台的工具
 */
public class WXMPUtils {

    private static final Logger logger = LoggerFactory.getLogger(WXMPUtils.class);

    /**
     * 微信公众号AppID
     */
    private SystemParameterHolder wxAppId;

    /**
     * 微信公众号AppSecret
     */
    private SystemParameterHolder wxAppSceret;

    /**
     * 微信公众号Token
     */
    private SystemParameterHolder wxAppToken;

    /**
     * REST模板
     */
    private RestTemplate restTemplate;

    /**
     * AccessToken
     */
    private volatile AccessTokenInfo accessTokenInfo;

    /**
     * Ticket
     */
    private volatile JsApiTicketInfo ticketInfo;

    /**
     * @param wxAppId
     *         微信公众号AppID
     */
    public void setWxAppId(SystemParameterHolder wxAppId) {
        this.wxAppId = wxAppId;
    }

    /**
     * @param wxAppSceret
     *         微信公众号AppSecret
     */
    public void setWxAppSceret(SystemParameterHolder wxAppSceret) {
        this.wxAppSceret = wxAppSceret;
    }

    /**
     * @param wxAppToken
     *         微信公众号Token
     */
    public void setWxAppToken(SystemParameterHolder wxAppToken) {
        this.wxAppToken = wxAppToken;
    }

    /**
     * @param restTemplate
     *         REST模板
     */
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 刷新AccessToken
     */
    private void refreshAccessToken() {
        HashMap<String, String> uriVars = new HashMap<>();
        uriVars.put("appId", wxAppId.getStringValue());
        uriVars.put("appSecret", wxAppSceret.getStringValue());
        accessTokenInfo = restTemplate.getForObject(Constants.GET_ACCESS_TOKEN_URL, AccessTokenInfo.class, uriVars);

        if (StringUtils.isEmpty(accessTokenInfo.getAccessToken())) {
            logger.error("Refresh access token failed:{}", accessTokenInfo);
            accessTokenInfo = null;
        }
    }

    /**
     * 刷新Ticket
     */
    private void refreshTicket() {
        HashMap<String, String> uriVars = new HashMap<>();
        uriVars.put("accessToken", getAccessToken());
        ticketInfo = restTemplate.getForObject(Constants.GET_JS_API_TICKET_URL, JsApiTicketInfo.class, uriVars);

        if (StringUtils.isEmpty(ticketInfo.getTicket())) {
            logger.error("Refresh JsApi ticket failed:{}", accessTokenInfo);
            ticketInfo = null;
        }
    }

    /**
     * @return AccessToken
     */
    private synchronized String getAccessToken() {
        if (accessTokenInfo == null) {
            refreshAccessToken();
        } else if (accessTokenInfo.getExpires().getTime() - System.currentTimeMillis() <= 600000) {
            refreshAccessToken();
        }

        return accessTokenInfo.getAccessToken();
    }

    /**
     * @return JSAPITicket
     */
    private synchronized String getTicket() {
        if (ticketInfo == null) {
            refreshTicket();
        } else if (ticketInfo.getExpires().getTime() - System.currentTimeMillis() <= 600000) {
            refreshTicket();
        }

        return ticketInfo.getTicket();
    }

    /**
     * 获取用户基本信息
     *
     * @param openId
     *         OpenId
     * @param locale
     *         语言
     * @return 用户基本信息
     */
    public UserInfo getUserInfo(String openId, Locale locale) {
        HashMap<String, Object> uriVars = new HashMap<>();
        uriVars.put("accessToken", getAccessToken());
        uriVars.put("openId", openId);
        uriVars.put("locale", locale);
        return restTemplate.getForObject(Constants.GET_USER_INFO_URL, UserInfo.class, uriVars);
    }

    /**
     * 处理微信对通知接口的校验
     *
     * @param nonce
     *         随机串
     * @param timestamp
     *         时间戳
     * @param signature
     *         签名
     * @param echostr
     *         响应字符串
     * @return 返回值
     */
    public String validateInf(String nonce, long timestamp, String signature, String echostr) {
        String[] array = {nonce, String.valueOf(timestamp), wxAppToken.getStringValue()};
        Arrays.sort(array);

        StringBuilder buffer = new StringBuilder();
        for (String s : array) {
            buffer.append(s);
        }

        return DigestUtils.sha1Hex(buffer.toString()).equalsIgnoreCase(signature) ? echostr : "false";
    }

    /**
     * 获取JsApi的初始化参数
     *
     * @param url
     *         页面URL
     * @return 初始化信息
     */
    public JsApiInitInfo getJsApiInitInfo(String url) {
        int sharpIdx = url.indexOf('#');
        if (sharpIdx >= 0) {
            url = url.substring(0, sharpIdx);
        }

        String nonceStr = UUID.randomUUID().toString().replaceAll("\\-", "").toUpperCase();
        long timestamp = System.currentTimeMillis() / 1000;

        TreeMap<String, String> sortedMap = new TreeMap<>();
        sortedMap.put("jsapi_ticket", getTicket());
        sortedMap.put("url", url);
        sortedMap.put("noncestr", nonceStr);
        sortedMap.put("timestamp", String.valueOf(timestamp));

        StringBuilder buffer = new StringBuilder();
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            buffer.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
        }
        buffer.deleteCharAt(buffer.length() - 1);

        String signature = DigestUtils.sha1Hex(buffer.toString());

        return new JsApiInitInfo(wxAppId.getStringValue(), timestamp, nonceStr, signature);
    }

    /**
     * 创建自定义菜单
     *
     * @param buttons
     *         菜单按钮
     * @return 操作结果
     */
    public BaseWithCommonOperationResult createMenu(List<Button> buttons) {
        HashMap<String, Object> uriVars = new HashMap<>();
        uriVars.put("accessToken", getAccessToken());

        MPResponse response = restTemplate.execute(Constants.CREATE_MENU_URL, HttpMethod.POST, new Jackson2JsonRequestCallback(new CreateMenuRequest(buttons)), Jackson2JsonOnlyResponseExtractor.getInstance(MPResponse.class), uriVars);

        if (response.getErrorCode().equals(Constants.SUCCESS)) {
            return new BaseWithCommonOperationResult(CommonOperationResult.Succeeded);
        } else {
            return new BaseWithCommonOperationResult(CommonOperationResult.Failed, response.getErrorCode() + ";" + response.getErrorMsg());
        }
    }

    /**
     * 删除自定义菜单
     *
     * @return 操作结果
     */
    public BaseWithCommonOperationResult deleteMenu() {
        HashMap<String, Object> uriVars = new HashMap<>();
        uriVars.put("accessToken", getAccessToken());
        MPResponse response = restTemplate.getForObject(Constants.DELETE_MENU_URL, MPResponse.class, uriVars);

        if (response.getErrorCode().equals(Constants.SUCCESS)) {
            return new BaseWithCommonOperationResult(CommonOperationResult.Succeeded);
        } else {
            return new BaseWithCommonOperationResult(CommonOperationResult.Failed, response.getErrorCode() + ";" + response.getErrorMsg());
        }
    }

}
