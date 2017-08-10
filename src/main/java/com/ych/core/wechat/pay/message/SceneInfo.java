package com.ych.core.wechat.pay.message;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 场景信息
 * <p>
 * Created by U on 2017/7/19.
 */
public class SceneInfo {

    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 门店所在地行政区划码
     */
    @JsonProperty("area_code")
    private String areaName;

    /**
     * 地址
     */
    private String address;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *         ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *         名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 门店所在地行政区划码
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * @param areaName
     *         门店所在地行政区划码
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * @return 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *         地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
