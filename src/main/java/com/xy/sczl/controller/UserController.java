package com.xy.sczl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xy.sczl.common.redis.RedisCache;
import com.xy.sczl.common.utils.UserUtil;
import com.xy.sczl.entity.UserInfoEntity;
import com.xy.sczl.service.UserInfoService;



@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Resource
    RedisCache redisCache;
	
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
        // str == null   str = "";
        if (StringUtils.isEmpty(userName)) {
        	return "请填写用户名";
        }
        if (StringUtils.isEmpty(password)) {
        	return "请填写密码";
        }
        UserInfoEntity user = userInfoService.findByUserName(userName);
        if (user != null) {
        	return "该用户已存在，请重新注册";
        }
        String userId = UserUtil.genUserId();
        userInfoService.addUser(userId, userName, password);
        // UserAccount userId
        return "user/userLogin";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request, HttpSession session) {

        return "user/userLogin";
    }
    
    // 点击登录时处理的数据
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logininfo(@RequestParam("username") String userName, 
    		@RequestParam("password") String password, HttpSession session) {
    	System.err.println("username=" + userName  + ",pwd=" + password);
        // 判断用户名或密码是否为空
        if (StringUtils.isEmpty(userName)||StringUtils.isEmpty(password))
        	{
        	return "请填写登录信息";
        }
        UserInfoEntity user = userInfoService.getUserNameAndPwd(userName, password);
        if (user == null) {
        	return "用户名或密码错误";
        }
		UserUtil.saveUserToSession(session, user);
        logger.debug("用户[{}]登陆成功",user.getUserName());
        redisCache.setString(user.getUserId(), user.getUserId(), 60*60*8);
        return "redirect:/user/index";
    }
}
