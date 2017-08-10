package com.ych.core.wechat.mp.authorization.dao.mybatis;

import com.ych.core.wechat.mp.authorization.UserAccessTokenInfo;
import com.ych.core.wechat.mp.authorization.dao.UserAccessTokenInfoDao;

/**
 * 用户AccessToken的Dao实现
 * <p>
 * Created by U on 2017/7/19.
 */
public class UserAccessTokenInfoDaoImpl implements UserAccessTokenInfoDao {

    private UserAccessTokenInfoMapper userAccessTokenInfoMapper;

    public void setUserAccessTokenInfoMapper(UserAccessTokenInfoMapper userAccessTokenInfoMapper) {
        this.userAccessTokenInfoMapper = userAccessTokenInfoMapper;
    }

    @Override
    public UserAccessTokenInfo selectByOpenId(String openId) {
        return userAccessTokenInfoMapper.selectByOpenId(openId);
    }

    @Override
    public int insert(UserAccessTokenInfo accessTokenInfo) {
        return userAccessTokenInfoMapper.insert(accessTokenInfo);
    }

    @Override
    public int update(UserAccessTokenInfo accessTokenInfo) {
        return userAccessTokenInfoMapper.update(accessTokenInfo);
    }
}
