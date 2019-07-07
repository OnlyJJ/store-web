package com.xy.sczl.service;

import com.xy.sczl.entity.UserInfoEntity;

public interface UserInfoService {
	
	/**
	 * 	添加用户
	 * @param userId	用户ID
	 * @param userName	用户名
	 * @param password	用户密码
	 * @return
	 */
	int addUser(String userId,String userName, String password);
	
	/**
	 * 	登录时查询用户和密码是否正确
	 * @param userName
	 * @param password
	 * @return
	 */
	UserInfoEntity getUserNameAndPwd(String userName, String password);
	
	/**
	 *  注册时根据用户名查询是否存在用户
	 * @param userName
	 * @return
	 */
	UserInfoEntity findByUserName(String userName);
}
