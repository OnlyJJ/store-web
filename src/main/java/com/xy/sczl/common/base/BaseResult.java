package com.xy.sczl.common.base;

/**
 * 返回前端的结果封装
 * @author dell
 *
 * @param <T>
 */
public class BaseResult<T> {
	/**
	 * 响应码
	 */
	private int code = 200;
	/**
	 * 响应说明
	 */
	private String msg = "success";
	/**
	 * 响应数据
	 */
	private T data;
	
	public BaseResult(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
