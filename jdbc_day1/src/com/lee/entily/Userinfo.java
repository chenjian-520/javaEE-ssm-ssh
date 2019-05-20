package com.lee.entily;

public class Userinfo {
	private int uid;
	private String uname;
	private String password;
	
	public Userinfo(int uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Userinfo [uid=" + uid + ", uname=" + uname + ", password=" + password + "]";
	}

	public Userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
