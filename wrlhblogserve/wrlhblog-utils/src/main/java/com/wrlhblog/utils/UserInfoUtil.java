package com.wrlhblog.utils;

import com.wrlhblog.model.User;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * 通过securityContext 获取到当前登录的用户
 */
public class UserInfoUtil {

    public static User getUser() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

    }

}
