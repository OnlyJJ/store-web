package com.xy.sczl.common.utils;


import javax.servlet.http.HttpSession;


import com.xy.sczl.common.constants.Constants;
import com.xy.sczl.entity.AdminEntity;


/**
 * 管理员工具类
 *
 */
public class AdminUtil {

    public static final String ADMIN = Constants.LOGIN_ADMIN;

    /**
     * 设置用户到session
     *
     * @param session
     * @param admin
     */
    public static void saveAdminToSession(HttpSession session, AdminEntity admin) {
        UserUtil.deleteUserFromSession(session);
        session.setAttribute(ADMIN,admin);
    }

    /**
     * 从Session获取当前管理信息
     *
     * @param session
     * @return
     */
    public static AdminEntity getAdminFromSession(HttpSession session) {
        Object attribute = session.getAttribute(ADMIN);
        return attribute == null ? null : (AdminEntity) attribute;
    }

    /**
     * 从Session中删除登陆管理的信息
     *
     * @param session
     */
    public static void deleteAdminFromSession(HttpSession session) {
        session.removeAttribute(ADMIN);
    }
}
