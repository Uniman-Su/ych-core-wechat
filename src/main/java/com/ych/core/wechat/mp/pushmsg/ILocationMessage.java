package com.ych.core.wechat.mp.pushmsg;

/**
 * 地理位置消息
 * <p>
 * Created by U on 2017/6/30.
 */
public interface ILocationMessage extends IMessage {

    /**
     * @return 纬度
     */
    Double getLocationX();

    /**
     * @return 经度
     */
    Double getLocationY();

    /**
     * @return 地图缩放大小
     */
    Integer getScale();

    /**
     * @return 地理位置信息
     */
    String getLabel();

}
