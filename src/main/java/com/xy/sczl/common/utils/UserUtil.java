package com.xy.sczl.common.utils;


import javax.servlet.http.HttpSession;

import com.xy.sczl.common.constants.Constants;
import com.xy.sczl.entity.UserInfoEntity;


/**
 * 用户工具类
 *
 */
public class UserUtil {

    public static final String USER = Constants.LOGIN_USER;

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, UserInfoEntity user) {
        AdminUtil.deleteAdminFromSession(session);
        session.setAttribute(USER, user);
        
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static UserInfoEntity getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (UserInfoEntity) attribute;
    }

    /**
     * 从Session中删除登陆用户的个人信息
     *
     * @param session
     */
    public static void deleteUserFromSession(HttpSession session) {
        session.removeAttribute(USER);
    }
	/**
	 * 生成用户id
	 * @return
	 */
	public static String genUserId() {
		long time = System.currentTimeMillis();
		String timeStr = String.valueOf(time);
		return timeStr.substring(timeStr.length()-6, timeStr.length());
	}
}
