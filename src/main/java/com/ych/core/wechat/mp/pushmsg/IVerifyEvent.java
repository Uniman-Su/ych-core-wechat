package com.ych.core.wechat.mp.pushmsg;

import java.util.Date;

/**
 * 认证消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IVerifyEvent extends IPushEvent {

    /**
     * @return 过期时间
     */
    Date getExpiredTime();

}
