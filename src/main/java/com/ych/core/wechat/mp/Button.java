package com.ych.core.wechat.mp;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ych.core.wechat.mp.pushmsg.ButtonType;

/**
 * 自定义菜单按钮
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Button implements Serializable {

    private static final long serialVersionUID = 1337189950143206345L;

    /**
     * 二级菜单数组，个数应为1~5个
     */
    @JsonProperty("sub_button")
    private List<Button> subButton;

    /**
     * 菜单的响应动作类型
     */
    private ButtonType type;

    /**
     * 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    private String name;

    /**
     * 菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    /**
     * 网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url
     */
    private String url;

    /**
     * 调用新增永久素材接口返回的合法media_id
     */
    @JsonProperty("media_id")
    private String mediaId;

    /**
     * 小程序的appid
     */
    @JsonProperty("appid")
    private String appId;

    /**
     * 小程序的页面路径
     */
    @JsonProperty("pagepath")
    private String pagePath;

    /**
     * @return 二级菜单数组，个数应为1~5个
     */
    public List<Button> getSubButton() {
        return subButton;
    }

    /**
     * @param subButton
     *         二级菜单数组，个数应为1~5个
     */
    public void setSubButton(List<Button> subButton) {
        this.subButton = subButton;
    }

    /**
     * @return 菜单的响应动作类型
     */
    public ButtonType getType() {
        return type;
    }

    /**
     * @param type
     *         菜单的响应动作类型
     */
    public void setType(ButtonType type) {
        this.type = type;
    }

    /**
     * @return 菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *         菜单标题，不超过16个字节，子菜单不超过60个字节
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 菜单KEY值，用于消息接口推送，不超过128字节
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *         菜单KEY值，用于消息接口推送，不超过128字节
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return 网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     *         网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 调用新增永久素材接口返回的合法media_id
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId
     *         调用新增永久素材接口返回的合法media_id
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * @return 小程序的appid
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *         小程序的appid
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return 小程序的页面路径
     */
    public String getPagePath() {
        return pagePath;
    }

    /**
     * @param pagePath
     *         小程序的页面路径
     */
    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
