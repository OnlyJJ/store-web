package com.xy.sczl.dao;

import com.xy.sczl.entity.UserInfoEntity;

public interface UserInfoMapper {
	
	UserInfoEntity findByUserId(String userId);
}
