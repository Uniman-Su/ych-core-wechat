package com.ych.core.wechat.mp.pushmsg;

/**
 * 视频消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IVideoMessage extends IMediaMessage {

    /**
     * @return 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    String getThumbMediaId();

}
