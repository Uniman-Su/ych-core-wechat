package com.ych.core.wechat.mp.authorization.dao;

import com.ych.core.wechat.mp.authorization.UserAccessTokenInfo;

/**
 * 用户AccessToken信息的Dao
 * <p>
 * Created by U on 2017/7/17.
 */
public interface UserAccessTokenInfoDao {

    /**
     * 获取AccessToken信息
     *
     * @param openId
     *         OpenId
     * @return AccessToken信息
     */
    UserAccessTokenInfo selectByOpenId(String openId);

    /**
     * 插入AccessToken信息
     *
     * @param accessTokenInfo
     *         AccessToken信息
     * @return 插入的行数
     */
    int insert(UserAccessTokenInfo accessTokenInfo);

    /**
     * 更新AccessToken信息
     *
     * @param accessTokenInfo
     *         AccessToken信息
     * @return 更新的行数
     */
    int update(UserAccessTokenInfo accessTokenInfo);

}
