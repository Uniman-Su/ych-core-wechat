package com.ych.core.wechat.mp.pushmsg;

import org.springframework.http.MediaType;

/**
 * 推送消息响应
 *
 * @param <T>
 *         响应对象
 */
public class PushMessageResponse<T> implements IPushMessageResponse<T> {

    /**
     * 媒体类型
     */
    private MediaType mediaType;

    /**
     * 响应对象
     */
    private T response;

    /**
     * 默认构造方法
     */
    public PushMessageResponse() {

    }

    /**
     * 构造方法
     *
     * @param mediaType
     *         媒体类型
     * @param response
     *         响应对象
     */
    public PushMessageResponse(MediaType mediaType, T response) {
        this.mediaType = mediaType;
        this.response = response;
    }

    @Override
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * @param mediaType
     *         媒体类型
     */
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    @Override
    public T getResponse() {
        return response;
    }

    /**
     * @param response
     *         响应对象
     */
    public void setResponse(T response) {
        this.response = response;
    }
}
