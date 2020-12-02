package com.moon.moon_security.bean;


public class SysPara extends BaseEntity<Long> {

	private String k;
	private String val;
	private String des;

	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}

}
