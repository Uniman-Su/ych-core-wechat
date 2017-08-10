package com.ych.core.wechat.mp.pushmsg;

import org.springframework.http.MediaType;

/**
 * 推送消息的响应对象
 *
 * @param <T>
 *         响应对象
 */
public interface IPushMessageResponse<T> {

    /**
     * 默认响应
     */
    IPushMessageResponse<String> DEFAULT_RESPONSE = new PushMessageResponse<>(MediaType.TEXT_PLAIN, "success");

    /**
     * @return 媒体类型
     */
    MediaType getMediaType();

    /**
     * @return 响应对象
     */
    T getResponse();

}
