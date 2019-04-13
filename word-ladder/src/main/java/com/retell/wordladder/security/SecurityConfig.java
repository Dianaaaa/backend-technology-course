package com.retell.wordladder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("654321")).roles("ADMIN")
                .and()
                .withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/login", "/user").permitAll()
                .antMatchers("/monitor/**").hasRole("ADMIN")
                .antMatchers("/word-ladder").hasRole("USER")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .permitAll()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/**")
                .authenticated()
                .and()
                .formLogin().loginPage("/user")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        String username = authentication.getName();
                        response.setContentType("application/json;charset=utf-8");
                        List<String> authorities = new ArrayList<>();
                        for (GrantedAuthority authority :authentication.getAuthorities()) {
                            authorities.add(authority.getAuthority());
                        }
                        PrintWriter out = response.getWriter();
                        out.write("{\"status\": 200,\"msg\":\"login success\",\"user\":\""+ username+ "\"}");
                        out.flush();
                        out.close();
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override

                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        System.out.println("password:"+httpServletRequest.getParameter("password"));
                        out.write("{\"status\":\"error\",\"msg\":\""+e.getMessage()+"\"}");
                        out.flush();
                        out.close();
                    }
                })
                .loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter out = response.getWriter();
                        request.getSession().invalidate();
                        out.write("{\"status\":200}");
                        out.flush();
                        out.close();
                    }
                })
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("123456").roles("USER").build());
//        manager.createUser(users.username("admin").password("654321").roles("USER", "ADMIN").build());
//        return manager;
//
//    }
}
