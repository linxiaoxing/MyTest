package com.anjoyo.info;
/**
 * 签到数据封装类
 * */
public class SignInfo {

	private String signid;
	private String sid;
	private String pid;
	private String name;
	private String signcontent;
	private String signlevel;
	private String signimage;
	private String signtime;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSignid() {
		return signid;
	}
	public void setSignid(String signid) {
		this.signid = signid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSigncontent() {
		return signcontent;
	}
	public void setSigncontent(String signcontent) {
		this.signcontent = signcontent;
	}
	public String getSignlevel() {
		return signlevel;
	}
	public void setSignlevel(String signlevel) {
		this.signlevel = signlevel;
	}
	public String getSignimage() {
		return signimage;
	}
	public void setSignimage(String signimage) {
		this.signimage = signimage;
	}
	public String getSigntime() {
		return signtime;
	}
	public void setSigntime(String signtime) {
		this.signtime = signtime;
	}



}
