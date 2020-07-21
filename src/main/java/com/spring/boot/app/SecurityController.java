package com.spring.boot.app;

import com.spring.boot.app.song.SongService;
import com.spring.boot.app.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityController extends WebSecurityConfigurerAdapter {


    private UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
        }


    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       http.headers().disable();

        http.authorizeRequests().antMatchers("/songs/*").hasAnyAuthority( "ADMIN")
        .antMatchers("/songs").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/{username}/*/*").hasAuthority("USER")
                .antMatchers("/{username}/*").hasAuthority("USER")
                .and().formLogin().permitAll().successForwardUrl("/songs")
                .and().logout();
    }}
