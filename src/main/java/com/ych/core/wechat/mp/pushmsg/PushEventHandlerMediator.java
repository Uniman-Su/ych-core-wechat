package com.ych.core.wechat.mp.pushmsg;

import java.util.List;

import com.ych.core.wechat.mp.MsgType;

public class PushEventHandlerMediator extends PushMsgHandlerMediator implements PushEventHandler {

    @Override
    public boolean isSupport(MsgType msgType) {
        return MsgType.event == msgType;
    }

    @Override
    public boolean isSupport(EventType eventType) {
        return true;
    }

    /**
     * @param handlers
     *         事件处理器
     */
    public void setEventHandlers(List<? extends PushEventHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void setHandlers(List<? extends PushMsgHandler> handlers) {
        throw new UnsupportedOperationException();
    }

    @SuppressWarnings("unchecked")
    private PushEventHandler getHandler(EventType eventType) {
        for (PushEventHandler handler : (List<? extends PushEventHandler>) handlers) {
            if (handler.isSupport(eventType)) {
                return handler;
            }
        }

        return null;
    }

    public IPushMessageResponse<?> handle(IPushMessage message) {
        IPushEvent event = (IPushEvent) message;
        PushEventHandler handler = getHandler(event.getEventType());

        if (handler != null) {
            return handler.handle(event);
        }

        return IPushMessageResponse.DEFAULT_RESPONSE;
    }

}
