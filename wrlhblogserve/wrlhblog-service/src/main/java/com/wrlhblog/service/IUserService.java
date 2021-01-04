package com.wrlhblog.service;

import com.wrlhblog.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
public interface IUserService extends UserDetailsService,IService<User> {

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
