package com.ych.core.wechat.mp.pushmsg;

import java.util.List;
import java.util.Map;

import com.ych.core.wechat.mp.MsgType;

/**
 * 推送消息处理器的中介者
 */
public class PushMsgHandlerMediator implements PushMsgHandler {

    /**
     * 根据消息类型处理的映射
     */
    protected List<? extends PushMsgHandler> handlers;

    /**
     * @param handlers
     *         根据消息类型处理的映射
     */
    public void setHandlers(List<? extends PushMsgHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public boolean isSupport(MsgType msgType) {
        return true;
    }

    protected PushMsgHandler getHandler(MsgType msgType) {
        for (PushMsgHandler handler : handlers) {
            if (handler.isSupport(msgType)) {
                return handler;
            }
        }

        return null;
    }

    public IPushMessageResponse<?> handle(IPushMessage message) {
        PushMsgHandler handler = getHandler(message.getMsgType());

        if (handler != null) {
            return handler.handle(message);
        }

        return IPushMessageResponse.DEFAULT_RESPONSE;
    }


}
