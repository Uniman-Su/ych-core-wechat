package com.ych.core.wechat.mp.authorization.dao.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ych.core.wechat.mp.authorization.UserAccessTokenInfo;

/**
 * AccessToken的Mapper
 * <p>
 * Created by U on 2017/7/17.
 */
public interface UserAccessTokenInfoMapper {

    /**
     * 获取AccessToken信息
     *
     * @param openId
     *         OpenId
     * @return AccessToken信息
     */
    @Select("SELECT openid, access_token, access_token_expires, refresh_token, refresh_token_expires, scope FROM t_user_wxaccesstoken WHERE openid = #{value,jdbcType=VARCHAR}")
    UserAccessTokenInfo selectByOpenId(String openId);

    /**
     * 插入AccessToken信息
     *
     * @param accessTokenInfo
     *         AccessToken信息
     * @return 插入的行数
     */
    @Insert("INSERT INTO t_user_wxaccesstoken (openid, access_token, access_token_expires, refresh_token, refresh_token_expires, scope) VALUES (#{openId,jdbcType=VARCHAR}, #{accessToken,jdbcType=VARCHAR}, #{accessTokenExpires,jdbcType=TIMESTAMP}, #{refreshToken,jdbcType=VARCHAR}, #{refreshTokenExpires,jdbcType=TIMESTAMP}, #{scope,jdbcType=NUMERIC})")
    int insert(UserAccessTokenInfo accessTokenInfo);

    /**
     * 更新AccessToken信息
     *
     * @param accessTokenInfo
     *         AccessToken信息
     * @return 更新的行数
     */
    @Update("UPDATE t_user_wxaccesstoken SET access_token = #{accessToken,jdbcType=VARCHAR}, access_token_expires = #{accessTokenExpires,jdbcType=TIMESTAMP}, refresh_token = #{refreshToken,jdbcType=VARCHAR}, refresh_token_expires = #{refreshTokenExpires,jdbcType=TIMESTAMP}, scope = #{scope,jdbcType=NUMERIC} WHERE openid = #{openId,jdbcType=VARCHAR}")
    int update(UserAccessTokenInfo accessTokenInfo);

}
