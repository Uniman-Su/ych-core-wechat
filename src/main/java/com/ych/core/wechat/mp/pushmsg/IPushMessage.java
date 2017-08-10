package com.ych.core.wechat.mp.pushmsg;

import java.io.Serializable;
import java.util.Date;

import com.ych.core.wechat.mp.MsgType;

/**
 * 微信服务端推送消息到开发者服务器的事件
 *
 * Created by U on 2017/6/30.
 */
public interface IPushMessage extends Serializable {

    /**
     * @return 消息接收方
     */
    String getReceiver();

    /**
     * @return 消息发送方
     */
    String getSender();

    /**
     * @return 创建时间
     */
    Date getCreateTime();

    /**
     * @return 消息类型
     */
    MsgType getMsgType();

}
