package com.ych.core.wechat.mp;

/**
 * 公众平台的消息类型
 *
 * Created by U on 2017/6/30.
 */
public enum MsgType {

    /**
     * 事件
     */
    event,

    /**
     * 文本消息
     */
    text,

    /**
     * 图片消息
     */
    image,

    /**
     * 语音消息
     */
    voice,

    /**
     * 视频消息
     */
    video,

    /**
     * 小视频消息
     */
    shortvideo,

    /**
     * 地理位置消息
     */
    location,

    /**
     * 链接消息
     */
    link;

}
