package com.moon.moon_security.bean;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 2054813493011812469L;

	private ID id;
    private String createTime;
    private String updateTime;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

    public String getCreateTime() {
		return createTime;
	}

    public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

    public String getUpdateTime() {
		return updateTime;
	}

    public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
