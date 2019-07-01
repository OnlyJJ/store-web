package com.xy.sczl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "user/index";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "user/userReg";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request, HttpSession session) {
        String uuid;
//        if (StringUtils.isNotBlank(uuid = CookieUtil.getCookieValue(request, appConfig.USER_COOKIE_NAME))) {
//            Remember remember = rememberService.findById(uuid);
//            if (remember != null && remember.getUser() != null) {
//                if (userService.checkLogin(remember.getUser())) {
//                    UserUtil.saveUserToSession(session, remember.getUser());
//                    logger.info("用户[{}]使用cookie登录成功.", remember.getUser().getUsername());
//                    return "redirect:/";
//                }
//            }
//        }
        return "user/userLogin";
    }
}
