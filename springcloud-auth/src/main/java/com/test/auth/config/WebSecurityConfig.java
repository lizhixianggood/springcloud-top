package com.test.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.auth.service.impl.MyUserDetails;

/**
 * web安全配置
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetails userServiceDetail;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    

    /**
     * 安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置密码模式服务器
        http.authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/rsa/publicKey").permitAll()
                .antMatchers("/**").authenticated()
                .and()//HttpSecurity
                .httpBasic()
                .and()
                .csrf().disable()//防csrf攻击 禁用
        ;

    }

    @Override//通过重载该方法，可配置Spring Security的Filter链（HTTP请求安全处理）
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    //设置密码加密规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceDetail).passwordEncoder(passwordEncoder);
    }

   

    //这一步的配置是必不可少的，否则SpringBoot会自动配置一个AuthenticationManager,覆盖掉内存中的用户
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}