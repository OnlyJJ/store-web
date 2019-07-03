package com.xy.sczl.entity;

import com.xy.sczl.common.base.BaseModel;

/**
 * 用户
 *
 */
@SuppressWarnings("serial")
public class UserInfoEntity extends BaseModel {
	private Integer id;
	private String userName;
	private String password;
	/**
	 * 是否删除：0未删，1已删
	 */
	private Integer isDeleted;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
}
