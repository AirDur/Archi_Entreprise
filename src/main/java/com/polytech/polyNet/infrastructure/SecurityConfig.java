package com.polytech.polyNet.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .mvcMatchers("/admin").hasRole("admin")
                .mvcMatchers("/about", "help").permitAll()
                //.and()
                //.httpBasic()
                //.and()
                //.formLogin().loginPage("/login").successForwardUrl("/")
                //.failureForwardUrl("/error/402")
                .and()
                .csrf().disable();
        super.configure(http);
    }
}
