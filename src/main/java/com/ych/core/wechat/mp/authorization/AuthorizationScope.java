package com.ych.core.wechat.mp.authorization;

import com.ych.core.model.IntValueHolder;

/**
 * 授权空间
 * <p>
 * Created by U on 2017/7/17.
 */
public enum AuthorizationScope implements IntValueHolder<AuthorizationScope> {

    /**
     * 不弹出授权页面，直接跳转，只能获取用户openid
     */
    snsapi_base(0),

    /**
     * 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息
     */
    snsapi_userinfo(1);

    private int value;

    AuthorizationScope(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
