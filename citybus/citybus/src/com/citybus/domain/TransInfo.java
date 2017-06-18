package com.citybus.domain;

import java.util.List;

public class TransInfo {

	private String lname1;
	private String lname2;
	private String lname3;
	
	private String snameS;
	private String sname1;
	private String sname2;
	private String snameE;
	
	private Integer ordeS;
	private Integer orde1;
	private Integer orde2;
	private Integer ordeE;

	

	public Integer getOrdeS() {
		return ordeS;
	}

	public void setOrdeS(Integer ordeS) {
		this.ordeS = ordeS;
	}

	public Integer getOrde1() {
		return orde1;
	}

	public void setOrde1(Integer orde1) {
		this.orde1 = orde1;
	}

	public Integer getOrde2() {
		return orde2;
	}

	public void setOrde2(Integer orde2) {
		this.orde2 = orde2;
	}

	public Integer getOrdeE() {
		return ordeE;
	}

	public void setOrdeE(Integer ordeE) {
		this.ordeE = ordeE;
	}

	private List<String> LineString;

	public String getLname1() {
		return lname1;
	}

	public void setLname1(String lname1) {
		this.lname1 = lname1;
	}

	public String getLname2() {
		return lname2;
	}

	public void setLname2(String lname2) {
		this.lname2 = lname2;
	}

	public String getLname3() {
		return lname3;
	}

	public void setLname3(String lname3) {
		this.lname3 = lname3;
	}

	public String getSnameS() {
		return snameS;
	}

	public void setSnameS(String snameS) {
		this.snameS = snameS;
	}

	public String getSname1() {
		return sname1;
	}

	public void setSname1(String sname1) {
		this.sname1 = sname1;
	}

	public String getSname2() {
		return sname2;
	}

	public void setSname2(String sname2) {
		this.sname2 = sname2;
	}

	public String getSnameE() {
		return snameE;
	}

	public void setSnameE(String snameE) {
		this.snameE = snameE;
	}

	public List<String> getLineString() {
		return LineString;
	}

	public void setLineString(List<String> lineString) {
		LineString = lineString;
	}
	
}
