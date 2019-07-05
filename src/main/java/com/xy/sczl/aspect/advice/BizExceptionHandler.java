package com.xy.sczl.aspect.advice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xy.sczl.common.base.Result;
import com.xy.sczl.common.exception.BizException;
import com.xy.sczl.common.utils.ResultUtil;

/**
 * controller异常拦截处理类
 * @author dell
 *
 */
@SuppressWarnings("rawtypes")
@ControllerAdvice
public class BizExceptionHandler {

	public static Logger LOG = LoggerFactory.getLogger(BizExceptionHandler.class);
	
	/**
	 * 统一异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public Result handle(HttpServletRequest request, Exception e) {
		LOG.error(e.getMessage(), e);
		Result res = ResultUtil.error();
		if(e instanceof BizException) {
			System.err.println("biz e...");
			res.addObject("msg", e.getMessage());
			res.addObject("code", ((BizException) e).getCode());
			res.addObject("url", request.getContextPath());
		} else {
			System.err.println("e...");
			res.addObject("/error/404");
		}
		return res;
	}
	
}
