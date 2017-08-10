package com.ych.core.wechat.mp.pushmsg;

/**
 * 视图跳转菜单事件
 * <p>
 * Created by U on 2017/6/30.
 */
public interface IViewMenuEvent extends IMenuEvent {

    /**
     * @return 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
     */
    String getMenuId();

}
