package com.xy.sczl.model.param;

import com.xy.sczl.common.base.BaseModel;

@SuppressWarnings("serial")
public class ErrorInfo extends BaseModel {
	/**
	 * 处理登录错误信息
	 */
	private String eInfo;

	public String geteInfo() {
		return eInfo;
	}

	public void seteInfo(String eInfo) {
		this.eInfo = eInfo;
	}
	
}
