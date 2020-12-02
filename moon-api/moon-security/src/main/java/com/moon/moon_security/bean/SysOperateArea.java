package com.moon.moon_security.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 系统营运区域表
 *
 * @author Boomer
 * @version 1.0
 * @since 2018/01/24
 */
public class SysOperateArea implements Serializable {


    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String uuid;
    /**
     * 运营区域名称
     */
    private String name;
    /**
     * 状态（1：有效，2：失效）
     */
    private Integer status;
    /**
     * 排序权重
     */
    private Integer sort;
    /**
     * 招募url
     */
    private String recruitUrl;
    /**
     * 是否默认
     */
    private Integer isDefault;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 更新时间
     */
    private Timestamp updateTime;
    /**
     * 更新者
     */
    private String updater;
    /**
     * 应用ID
     */
    private String appid;
    /*** 最后更新时间 **/
    private Timestamp lastUpdTime;

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Timestamp getLastUpdTime() {
        return lastUpdTime;
    }

    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    public String getRecruitUrl() {
        return recruitUrl;
    }

    public void setRecruitUrl(String recruitUrl) {
        this.recruitUrl = recruitUrl;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
