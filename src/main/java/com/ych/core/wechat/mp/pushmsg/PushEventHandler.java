package com.ych.core.wechat.mp.pushmsg;

/**
 * 推送事件处理器
 */
public interface PushEventHandler extends PushMsgHandler {

    /**
     * 是否支持这个事件类型
     *
     * @param eventType
     *         事件类型
     * @return 支持则返回true
     */
    boolean isSupport(EventType eventType);

}
