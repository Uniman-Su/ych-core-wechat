package com.ych.core.wechat.mp.pushmsg;

import java.math.BigInteger;

/**
 * 消息
 *
 * Created by U on 2017/6/30.
 */
public interface IMessage extends IPushMessage {

    /**
     * @return 消息ID
     */
    BigInteger getMsgId();

}
