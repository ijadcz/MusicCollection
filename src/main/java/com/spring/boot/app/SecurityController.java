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


   // private SongService songService;
    private UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
     //   this.songService = songService;
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests().antMatchers("/playlist").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/add").hasAuthority("ADMIN")
                .antMatchers("/delete/**").hasAuthority("ADMIN")
                .antMatchers("/update/**").hasAuthority("ADMIN")
              .antMatchers("/username").hasAnyAuthority("USER")
              .antMatchers("/songs").hasAnyAuthority("USER")
                .and().formLogin().permitAll();
    }
*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       http.headers().disable();

        http.authorizeRequests().antMatchers("/songs").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/add").hasAuthority("ADMIN")
                .antMatchers("/delete/**").hasAuthority("ADMIN")
                .antMatchers("/update/**").hasAuthority("ADMIN")
                .antMatchers("/*/playlist").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/*").hasAnyAuthority("USER", "ADMIN")
                .and().formLogin().permitAll().successForwardUrl("/songs");
    }}
/*
@Configuration
@EnableWebSecurity
public class SecurityController extends WebSecurityConfigurerAdapter {


    private  SongService songService;
    private UserService userService;

    public SecurityController(UserService userService, SongService songService) {
        this.userService = userService;
        this.songService= songService;
    }


    @Bean
    public PasswordEncoder getPasswordEncoder(){

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
       http.authorizeRequests().antMatchers("/songs").hasAnyAuthority("USER", "ADMIN")
   .antMatchers("/playlist").hasAnyAuthority("USER")
        .antMatchers("/add").hasAuthority("ADMIN")
        .antMatchers("/delete/**").hasAuthority("ADMIN")
        .antMatchers("/update/**").hasAuthority("ADMIN")
               .and().formLogin();
    }
/*
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetailsImpl userDetails =  User.withDefaultPasswordEncoder()
                .username("user1")
                .password("user1")
                .roles("USER")
                .build();

        UserDetailsImpl adminDetails = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails,adminDetails);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/songs").hasRole("USER")
                .anyRequest().hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }*/
