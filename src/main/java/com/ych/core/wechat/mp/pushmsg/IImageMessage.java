package com.ych.core.wechat.mp.pushmsg;

/**
 * 图片消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IImageMessage extends IMediaMessage {

    /**
     * @return 图片URL
     */
    String getPicUrl();

}
