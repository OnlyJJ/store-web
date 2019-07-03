package com.xy.sczl.entity;


import com.xy.sczl.common.base.BaseModel;

/**
 * 管理员
 * 
 */
@SuppressWarnings("serial")
public class AdminEntity extends BaseModel {
	private String userId;
	private String username;//账户名
	private String password;//密码

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
