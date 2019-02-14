package com.soft863.entity;

import java.io.Serializable;

public class User_Bean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942474556305578244L;
	private String msg;
	private String account;
	private String password;
	
	public User_Bean() {

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User_Bean [msg=" + msg + ", account=" + account + ", password=" + password + "]";
	}
	
	
}

