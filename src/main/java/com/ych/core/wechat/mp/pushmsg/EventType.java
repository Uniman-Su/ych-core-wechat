package com.ych.core.wechat.mp.pushmsg;

/**
 * 事件类型
 *
 * Created by U on 2017/6/30.
 */
public enum EventType {

    /**
     * 订阅
     */
    subscribe,

    /**
     * 取消订阅
     */
    unsubscribe,

    /**
     * 扫描带参数二维码事件
     */
    SCAN,

    /**
     * 上报地理位置事件
     */
    LOCATION,

    /**
     * 点击菜单拉取消息时的事件推送
     */
    CLICK,

    /**
     * 点击菜单跳转链接时的事件推送
     */
    VIEW,

    /**
     * 资质认证成功
     */
    qualification_verify_success,

    /**
     * 资质认证失败
     */
    qualification_verify_fail,

    /**
     * 名称认证成功
     */
    naming_verify_success,

    /**
     * 名称认证失败
     */
    naming_verify_fail,

    /**
     * 年审通知
     */
    annual_renew,

    /**
     * 认证过期失效通知
     */
    verify_expired;

}
