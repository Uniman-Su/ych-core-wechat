package com.ych.core.wechat.mp.pushmsg;

/**
 * 上报地理位置事件.用户同意上报地理位置后，每次进入公众号会话时，都会在进入时上报地理位置，或在进入会话后每5秒上报一次地理位置，公众号可以在公众平台网站中修改以上设置。
 * <p>
 * Created by U on 2017/6/30.
 */
public interface ILocationEvent extends IPushEvent {

    /**
     * @return 地理位置纬度
     */
    Double getLatitude();

    /**
     * @return 地理位置经度
     */
    Double getLongitude();

    /**
     * @return 地理位置精度
     */
    Double getPrecision();

}
