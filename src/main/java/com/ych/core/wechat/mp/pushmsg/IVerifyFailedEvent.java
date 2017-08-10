package com.ych.core.wechat.mp.pushmsg;

import java.util.Date;

/**
 * 认证失败消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IVerifyFailedEvent {

    /**
     * @return 失败时间
     */
    Date getFailTime();

    /**
     * @return 失败原因
     */
    String getFailReason();

}
