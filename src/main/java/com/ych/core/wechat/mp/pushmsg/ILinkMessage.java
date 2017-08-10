package com.ych.core.wechat.mp.pushmsg;

/**
 * 链接消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface ILinkMessage extends IMessage {

    /**
     * @return 消息标题
     */
    String getTitle();

    /**
     * @return 消息描述
     */
    String getDescription();

    /**
     * @return 消息链接
     */
    String getUrl();

}
