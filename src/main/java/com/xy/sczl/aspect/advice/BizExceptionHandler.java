package com.xy.sczl.aspect.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xy.sczl.common.base.BaseResult;
import com.xy.sczl.common.constants.ErrorCode;
import com.xy.sczl.common.exception.BizException;

/**
 * controller异常拦截处理类
 * @author dell
 *
 */
@ControllerAdvice
@ResponseBody
public class BizExceptionHandler {

	public static Logger LOG = LoggerFactory.getLogger(BizExceptionHandler.class);
	
	/**
	 * 未知异常统一抛出此异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public BaseResult<?> handle(Exception e) {
		LOG.error(e.getMessage(), e);
		return new BaseResult(ErrorCode.Error.getCode(), ErrorCode.Error.getMsg());
	}
	
	/**
	 * 自定义异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	public BaseResult<?> handle(BizException e) {
		LOG.error(e.getMessage(), e);
		return new BaseResult(e.getCode(), e.getMessage());
	}
}
