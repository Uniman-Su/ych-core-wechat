package com.ych.core.wechat.mp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ych.core.fasterxml.jackson.databind.deser.DateUnixTimestampDeserializer;
import com.ych.core.fasterxml.jackson.databind.deser.IntBooleanDeserializer;
import com.ych.core.fasterxml.jackson.databind.ser.DateUnixTimestampSerializer;
import com.ych.core.fasterxml.jackson.databind.ser.IntBooleanSerializer;

/**
 * 用户信息
 * <p>
 * Created by U on 2017/7/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo extends BasicUserInfo implements Serializable {

    private static final long serialVersionUID = -561188928442711916L;

    /**
     * 用户是否订阅公众号
     */
    @JsonSerialize(using = IntBooleanSerializer.class)
    @JsonDeserialize(using = IntBooleanDeserializer.class)
    private boolean subscribe;

    /**
     * 订阅时间
     */
    @JsonProperty("subscribe_time")
    @JsonSerialize(using = DateUnixTimestampSerializer.class)
    @JsonDeserialize(using = DateUnixTimestampDeserializer.class)
    private Date subscribeTime;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 用户所在的分组ID（暂时兼容用户分组旧接口）
     */
    @JsonProperty("groupid")
    private BigDecimal groupId;

    /**
     * 用户被打上的标签ID列表
     */
    @JsonProperty("tagid_list")
    private List<BigDecimal> tagIds;

    /**
     * @return 用户是否订阅公众号
     */
    public boolean isSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe
     *         用户是否订阅公众号
     */
    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * @return 订阅时间
     */
    public Date getSubscribeTime() {
        return subscribeTime;
    }

    /**
     * @param subscribeTime
     *         订阅时间
     */
    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    /**
     * @return 用户备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *         用户备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 用户所在的分组ID（暂时兼容用户分组旧接口）
     */
    public BigDecimal getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     *         用户所在的分组ID（暂时兼容用户分组旧接口）
     */
    public void setGroupId(BigDecimal groupId) {
        this.groupId = groupId;
    }

    /**
     * @return 用户被打上的标签ID列表
     */
    public List<BigDecimal> getTagIds() {
        return tagIds;
    }

    /**
     * @param tagIds
     *         用户被打上的标签ID列表
     */
    public void setTagIds(List<BigDecimal> tagIds) {
        this.tagIds = tagIds;
    }

}
