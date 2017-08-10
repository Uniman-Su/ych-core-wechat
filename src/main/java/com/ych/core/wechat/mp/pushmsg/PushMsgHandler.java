package com.ych.core.wechat.mp.pushmsg;

import com.ych.core.wechat.mp.MsgType;

/**
 * 推送消息处理器
 */
public interface PushMsgHandler {

    /**
     * 该处理器是否支持该消息类型
     *
     * @param msgType
     *         消息类型
     * @return 支持返回true
     */
    boolean isSupport(MsgType msgType);

    /**
     * 处理推送消息
     *
     * @param pushMessage
     *         推送消息
     * @return 响应对象
     */
    IPushMessageResponse<?> handle(IPushMessage pushMessage);

}
