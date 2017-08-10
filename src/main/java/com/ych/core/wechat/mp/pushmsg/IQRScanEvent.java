package com.ych.core.wechat.mp.pushmsg;

/**
 * 带参数二维码扫描事件
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IQRScanEvent extends IPushEvent {

    /**
     * @return 事件KEY值<br>
     * 用户未关注时扫描,之后进行关注,推送类似"qrscene_123123",qrscene_为前缀,后面为二维码的参数值<br>
     * 用户已关注时扫描是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    String getEventKey();

    /**
     * @return 二维码的ticket，可用来换取二维码图片
     */
    String getTicket();

}
