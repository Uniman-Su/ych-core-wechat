package com.ych.core.wechat.mp;

import com.ych.core.model.IntValueHolder;

/**
 * 用户性别
 * <p>
 * Created by U on 2017/7/13.
 */
public enum UserSex implements IntValueHolder<UserSex> {

    /**
     * 未知
     */
    UNKNOWN(0),

    /**
     * 男性
     */
    MALE(1),

    /**
     * 女性
     */
    FEMALE(2);

    private int value;

    UserSex(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

}
