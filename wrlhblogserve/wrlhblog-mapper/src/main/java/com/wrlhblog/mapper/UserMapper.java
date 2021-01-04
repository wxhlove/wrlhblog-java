package com.wrlhblog.mapper;

import com.wrlhblog.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author
 * @since 2020-12-29
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User loadUserByUsername(@Param("username") String username);
}
