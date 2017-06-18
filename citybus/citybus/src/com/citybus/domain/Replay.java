package com.citybus.domain;

public class Replay {

	private int id;
	private String replaycontent;
	private String replaytime;
	private String replayer;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getReplayer() {
		return replayer;
	}
	public void setReplayer(String replayer) {
		this.replayer = replayer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getReplaycontent() {
		return replaycontent;
	}
	public void setReplaycontent(String replaycontent) {
		this.replaycontent = replaycontent;
	}
	public String getReplaytime() {
		return replaytime;
	}
	public void setReplaytime(String replaytime) {
		this.replaytime = replaytime;
	}
	
}
