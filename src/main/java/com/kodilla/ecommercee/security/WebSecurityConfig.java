package com.kodilla.ecommercee.security;

import com.kodilla.ecommercee.config.AdminConfig;
import com.kodilla.ecommercee.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private UserConfig userConfig;

    private static final String ADMIN = "ADMIN";
    private static final String USER = "USER";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("v1/").permitAll()
                .antMatchers("v1/product", "v1/group", "v1/user").hasRole(ADMIN)
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("v1/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails admin =
                User.builder()
                    .username(adminConfig.getAdminLogin())
                    .password(adminConfig.getAdminPassword())
                    .roles(ADMIN)
                    .build();
        UserDetails user =
                User.builder()
                    .username(userConfig.getLogin())
                    .password(userConfig.getPassword())
                    .roles(USER)
                    .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
