package com.bank.application.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users", "/users/*", "/users/employees").permitAll()
                .antMatchers(
                        HttpMethod.POST,
                        "users/"
                ).permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/users/clients",
                        "/users/employees",
                        "/accounts",
                        "/users"
                ).hasRole("ADMIN")
//                .antMatchers(
//                        HttpMethod.POST,
//                        "/users"
//                ).hasRole("ADMIN")
                .antMatchers(
                        HttpMethod.DELETE,
                        "/users"
                ).hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
//                .and()
//                .formLogin();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails misha = User.builder()
                .username("mishaSlivka")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build();

        UserDetails andriy = User.builder()
                .username("andru")
                .password(passwordEncoder.encode("password"))
                .roles("CLIENT")
                .build();

        return new InMemoryUserDetailsManager(misha, andriy);
    }
}
