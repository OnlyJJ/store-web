package com.xy.sczl.dao;

import org.apache.ibatis.annotations.Param;

import com.xy.sczl.entity.UserInfoEntity;

public interface UserInfoMapper {
	
	int insert(UserInfoEntity user);
	
	/**
	 * 添加用户
	 * @param userNmae	用户名
	 * @param password	密码
	 * @return
	 */
	int insert(@Param("userId")String userId,@Param("userName") String userName, @Param("password")String password);
	
	/**
	 * 	根据用户名和密码查询用户是否存在
	 * @param userName
	 * @param password
	 * @return
	 */
	UserInfoEntity getUserNameAndPwd(@Param("userName")String userName, @Param("password")String password);
	
	/**
	 *	 根据用户 ID 查询
	 * @param userId
	 * @return
	 */
	UserInfoEntity findByUserId(String userId);
	
	/**
	 * 	根据用户名查询
	 * @param userName
	 * @return
	 */
	UserInfoEntity findByUserName(String userName);
}
