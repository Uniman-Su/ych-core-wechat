package com.ych.core.wechat.mp.pushmsg;

/**
 * 菜单事件
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IMenuEvent extends IPushEvent {

    /**
     * @return 事件KEY值，与自定义菜单接口中KEY值对应
     */
    String getEventKey();

}
