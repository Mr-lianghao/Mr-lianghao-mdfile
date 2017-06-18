package com.citybus.domain;

import java.io.Serializable;

public class LineStation implements Serializable{

	private String id;
	private String lid;
	private String sid;
	private Integer orde;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public Integer getOrde() {
		return orde;
	}
	public void setOrde(Integer orde) {
		this.orde = orde;
	}
	
	
}
