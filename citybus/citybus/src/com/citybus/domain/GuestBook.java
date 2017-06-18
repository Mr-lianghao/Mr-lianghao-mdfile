package com.citybus.domain;

public class GuestBook {
	private Integer gid;
	private String nickname;
	private String email;
	private String qq;
	private String content1;
	private String addtime;
	private int replayid;
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getContent1() {
		return content1;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}
	
	public int getReplayid() {
		return replayid;
	}
	public void setReplayid(int replayid) {
		this.replayid = replayid;
	}
	

	
}
