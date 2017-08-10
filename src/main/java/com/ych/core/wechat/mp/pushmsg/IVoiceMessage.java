package com.ych.core.wechat.mp.pushmsg;

import com.ych.core.wechat.mp.VoiceFormat;

/**
 * 语音消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IVoiceMessage extends IMediaMessage {

    /**
     * @return 语音消息格式
     */
    VoiceFormat getFormat();

    /**
     * @return 语音识别内容
     */
    String getRecognition();

}
