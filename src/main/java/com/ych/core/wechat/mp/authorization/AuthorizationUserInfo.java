package com.ych.core.wechat.mp.authorization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ych.core.wechat.mp.BasicUserInfo;

/**
 * 授权接口返回的用户信息
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorizationUserInfo extends BasicUserInfo {

    private static final long serialVersionUID = -8589551273292225298L;

    /**
     * 用户特权信息
     */
    private List<String> privilege;

    /**
     * @return 用户特权信息
     */
    public List<String> getPrivilege() {
        return privilege;
    }

    /**
     * @param privilege
     *         用户特权信息
     */
    public void setPrivilege(List<String> privilege) {
        this.privilege = privilege;
    }

}
