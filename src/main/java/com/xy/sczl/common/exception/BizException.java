package com.xy.sczl.common.exception;

import com.xy.sczl.common.constants.ErrorCode;

/**
 * 业务系统异常
 * @author dell
 *
 */
@SuppressWarnings("serial")
public class BizException extends RuntimeException {
	private int code;
	
	private String message;
	
	private ErrorCode errorCode;
	
	public BizException(ErrorCode errorCode) {
		super(errorCode.getMsg());
		this.code = errorCode.getCode();
		this.message = errorCode.getMsg();
	}
	
	public BizException(String message) {
		super(message);
	}
	
	public BizException(int code, String message) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
