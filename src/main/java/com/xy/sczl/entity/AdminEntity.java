package com.xy.sczl.entity;

import java.io.Serializable;

import com.xy.sczl.common.base.BaseModel;

/**
 * 管理员
 * 
 */
public class AdminEntity extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
	private String username;//账户名
	private String password;//密码

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
