package com.ych.core.wechat.mp.pushmsg;

/**
 * 文本消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface ITextMessage extends IMessage {

    /**
     * @return 消息内容
     */
    String getContent();

}
