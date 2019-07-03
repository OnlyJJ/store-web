package com.xy.sczl.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xy.sczl.dao.UserInfoMapper;
import com.xy.sczl.entity.UserInfoEntity;
import com.xy.sczl.service.UserInfoService;
import com.xy.sczl.service.impl.UserInfoServiceImpl;

import ch.qos.logback.classic.Logger;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {

        return "user/userReg";
    }
    
    // 点击注册时处理的数据
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reginfo(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
//        System.err.println(userName);
//        System.err.println(password);
        if (userName == null) {
        	return "请填写用户名";
        }
        if (password == null) {
        	return "请填写密码";
        }
        UserInfoEntity user = userInfoMapper.findByUserName(userName);
        if (user != null) {
        	return "该用户已存在，请重新注册";
        }
        userInfoService.addUser(userName, password);
        return "user/userLogin";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request, HttpSession session) {

        return "user/userLogin";
    }
    
    // 点击登录时处理的数据
    @RequestMapping(value = "/logininfo", method = RequestMethod.POST)
    public String logininfo(HttpServletRequest request, HttpSession session) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        // 判断用户名或密码是否为空
        if (StringUtils.isEmpty(request.getParameter("username"))||StringUtils.isEmpty(request.getParameter("password")))
        	{
        	return "请填写登录信息";
        }
        UserInfoEntity user = userInfoService.getUserNameAndPwd(userName, password);
        if (user == null) {
        	return "用户名或密码错误";
        }
        // 保存用户 cookie
        Cookie userCookie = new Cookie("username", userName);
        
        return "user/index";
    }
}
