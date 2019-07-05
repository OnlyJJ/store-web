package com.xy.sczl.aspect.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xy.sczl.common.base.BaseResult;
import com.xy.sczl.common.exception.BizException;

/**
 * controller异常拦截处理类
 * @author dell
 *
 */
@ControllerAdvice
public class BizExceptionHandler {

	public static Logger LOG = LoggerFactory.getLogger(BizExceptionHandler.class);
	
	/**
	 * 未知异常统一抛出到错误页面
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView handle(Exception e) {
		LOG.error(e.getMessage(), e);
		ModelAndView model = new ModelAndView("/error/404");
		return model;
	}
	
	/**
	 * 自定义异常，返回json
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BizException.class)
	@ResponseBody
	public BaseResult<?> handle(BizException e) {
		LOG.error(e.getMessage(), e);
		return new BaseResult(e.getCode(), e.getMessage());
	}
}
