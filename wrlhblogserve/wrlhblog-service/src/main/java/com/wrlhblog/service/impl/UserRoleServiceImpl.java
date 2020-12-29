package com.wrlhblog.service.impl;

import com.wrlhblog.model.UserRole;
import com.wrlhblog.mapper.UserRoleMapper;
import com.wrlhblog.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
