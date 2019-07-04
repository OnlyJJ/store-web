package com.xy.sczl.common.constants;

/**
 * 异常枚举类
 * @author dell
 *
 */
public enum ErrorCode {
	
	/**
	 * 用户已存在
	 */
	ErrorCode_1002(1001, "用户已存在"),
	/**
	 * 用户不存在
	 */
	ErrorCode_1001(1001, "用户不存在"),
	/**
	 * 系统异常
	 */
	Error(-1, "系统异常");
	
	private String msg;
	private int code;
	
	private ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
