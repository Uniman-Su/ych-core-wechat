package com.ych.core.wechat.mp.pushmsg;

/**
 * 推送的事件
 *
 * Created by U on 2017/6/30.
 */
public interface IPushEvent extends IPushMessage {

    /**
     * @return 事件类型
     */
    EventType getEventType();

}
