package com.xy.sczl.common.utils;

import com.xy.sczl.common.base.Result;

public class ResultUtil {
	/**
	 * 响应成功
	 * @param <T>
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data) {
		Result<T> res = new Result<T>(200, "success");
		res.setData(data);
		return res;
	}
	
	public static <T> Result<T> error() {
		Result<T> res = new Result<T>();
		return res;
	}
	
	public static <T> Result<T> error(int code, String msg) {
		Result<T> res = new Result<T>(code, msg);
		return res;
	}
}
