package com.wcy.adminapi.config;

import com.alibaba.fastjson.JSONObject;
import com.wcy.adminapi.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    //根据一个url请求，获得访问它所需要的roles权限
    @Autowired
    MyFilterInvocationSecurityMetadataSource myFilterInvocationSecurityMetadataSource;

    //接收一个用户的信息和访问一个url所需要的权限，判断该用户是否可以访问
    @Autowired
    MyAccessDecisionManager myAccessDecisionManager;

    //403页面
    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //在这里配置哪些页面不需要认证
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/bower_components/**", "/noAuthenticate");
        web.ignoring().antMatchers("/build/**", "/noAuthenticate");
        web.ignoring().antMatchers("/dist/**", "/noAuthenticate");
        web.ignoring().antMatchers("/documentation/**", "/noAuthenticate");
        web.ignoring().antMatchers("/js/**", "/noAuthenticate");
        web.ignoring().antMatchers("/pages/**", "/noAuthenticate");
        web.ignoring().antMatchers("/plugins/**", "/noAuthenticate");
        web.ignoring().antMatchers("/index.html", "/noAuthenticate");
        web.ignoring().antMatchers("/admin/login", "/noAuthenticate");
    }

    /**定义安全策略*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()       //配置安全策略
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(myAccessDecisionManager);
                        return o;
                    }
                })

//                .antMatchers("/hello").hasAuthority("ADMIN")
                .and()
                .headers().frameOptions().disable().and()
                .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/loginCheck")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        StringBuffer sb = new StringBuffer();
                        out.write(JSONObject.toJSONString(ServerResponse.createByErrorMessage("用户名或密码错误")));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
//
                        out.write(JSONObject.toJSONString(ServerResponse.createBySuccess()));
                        out.flush();
                        out.close();
                    }
                })
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);
    }


}
