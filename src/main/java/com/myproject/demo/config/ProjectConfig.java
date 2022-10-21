package com.myproject.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthProvider authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
//                .httpBasic().and()
                .authorizeRequests()
                .antMatchers("/","/hello","/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout().permitAll();

//                .oauth2ResourceServer().jwt();
//        Okta.configureResourceServer401ResponseBody(http);
    }
}
