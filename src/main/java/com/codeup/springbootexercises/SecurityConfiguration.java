package com.codeup.springbootexercises;

import com.codeup.springbootexercises.services.UserDetailsLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Security configuration for application
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserDetailsLoader usersLoader;

    public SecurityConfiguration(UserDetailsLoader usersLoader) {
        this.usersLoader = usersLoader;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(usersLoader)
                .passwordEncoder(passwordEncoder())
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Login configuration
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/posts")
                .permitAll()
                // Logout configuration
            .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                // Pages viewable without logging in
            .and()
                .authorizeRequests()
                .antMatchers("/", "/posts")
                .permitAll()
                // Pages only viewable when logged in
            .and()
                .authorizeRequests()
                .antMatchers(
                        "/posts/create",
                        "/posts/{id}/edit",
                        "/profile",
                        "/posts/{id}/delete"
                )
                .authenticated()
        ;
    }
}
