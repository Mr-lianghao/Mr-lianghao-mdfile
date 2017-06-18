package com.citybus.domain;

import java.io.Serializable;

public class Line implements Serializable{

	private String lid;
	private String lname;
	private String type;
	private String company;
	private String people;
	private Integer tel;
	private String img_url;
	
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getLid() {
		return lid;
	}
	@Override
	public String toString() {
		return "Line [lid=" + lid + ", lname=" + lname + ", type=" + type
				+ ", company=" + company + ", people=" + people + ", tel="
				+ tel + "]";
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public Integer getTel() {
		return tel;
	}
	public void setTel(Integer tel) {
		this.tel = tel;
	}
	
	
	
}
