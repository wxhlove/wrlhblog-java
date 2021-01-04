package com.wrlhblog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wrlhblog.config.filter.SecurityAccessDecisionManager;
import com.wrlhblog.config.filter.SecurityFilter;
import com.wrlhblog.model.User;
import com.wrlhblog.service.IUserService;
import com.wrlhblog.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 配置security权限管理
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private IUserService iUserService;

    @Autowired
    private SecurityFilter securityFilter;

    @Autowired
    private SecurityAccessDecisionManager securityAccessDecisionManager;

    /**
     * 密码加密解密方案
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * 认证管理
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //将用户查询对比逻辑交给身份验证处理
        auth.userDetailsService(iUserService);
    }

    /**
     * http 页面相关配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //授权请求
        http.authorizeRequests()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {    //处理请求对象
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
//                        object.setSecurityMetadataSource(securityFilter);   //根据请求地址分析需要的角色
//                        object.setAccessDecisionManager(securityAccessDecisionManager); //访问决策管理器
//                        return object;
//                    }
//                })
                .anyRequest().authenticated()
                .and()
                .formLogin() //登录表单管理项
                .loginProcessingUrl("/dologin") //登录时的url地址
                .passwordParameter("password") //登录时的用户密码参数
                .usernameParameter("username") //登录时的用户名参数项
                .successHandler(new AuthenticationSuccessHandler() {  //登录成功时的出理项
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");  //返回各式
                        PrintWriter writer = response.getWriter();  //获取返回写方法
                        User user = (User) authentication.getPrincipal();
                        user.setPassword(null);
                        RespBean respBean = RespBean.ok("登录成功", user);
                        String respBeanStr = new ObjectMapper().writeValueAsString(respBean); // 将对象转换为字符串
                        writer.write(respBeanStr);  //写返回文件
                        writer.flush();
                        writer.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {  //登录失败的返回出理项
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");  //返回各式
                        PrintWriter writer = response.getWriter();  //获取返回写方法
                        //处理登录失败原因
                        RespBean respBean = RespBean.error("登录失败");
                        if (e instanceof LockedException) {
                            respBean.setMessage("账户被锁定，请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
                            respBean.setMessage("密码已过期,请联系管理员 ");
                        } else if (e instanceof DisabledException) {
                            respBean.setMessage("账户被禁用,请联系管理员 ");
                        } else if (e instanceof BadCredentialsException) {
                            respBean.setMessage("用户名或密码错误，请重新输入");
                        }
                        String respBeanStr = new ObjectMapper().writeValueAsString(respBean); // 将对象转换为字符串
                        writer.write(respBeanStr);  //写返回文件
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()  //从这里的接口都可以返回；
                .and()
                .logout() //注销登录
                .logoutSuccessHandler(new LogoutSuccessHandler() {  //注销成功出理项
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = response.getWriter();
                        RespBean respBean = RespBean.ok("注销成功");
                        String respBeanStr = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(respBeanStr);
                        writer.flush();
                        writer.close();
                    }
                })
                .permitAll()
                .and()
                .csrf() //跨域相关设置
                .disable() //关闭
                .exceptionHandling() //异常处理
                .authenticationEntryPoint(new AuthenticationEntryPoint() {  //认证入口点
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        response.setStatus(401);
                        PrintWriter writer = response.getWriter();
                        RespBean respBean = RespBean.error("访问失败");
                        if (e instanceof InsufficientAuthenticationException) {
                            System.out.println("e -- " + e);
                            respBean.setMessage("登录异常，请联系管理员");
                        }
                        String respBeanStr = new ObjectMapper().writeValueAsString(respBean);
                        writer.write(respBeanStr);
                        writer.flush();
                        writer.close();
                    }
                });
    }
}
