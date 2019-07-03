package com.xy.sczl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.sczl.dao.UserInfoMapper;
import com.xy.sczl.entity.UserInfoEntity;
import com.xy.sczl.service.UserInfoService;

@Service()
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public int addUser(String userName, String password) {
		// TODO Auto-generated method stub
		return userInfoMapper.insert(userName, password);
	}

	@Override
	public UserInfoEntity getUserNameAndPwd(String userName, String password) {
		// TODO Auto-generated method stub
		return userInfoMapper.getUserNameAndPwd(userName, password);
	}

}
