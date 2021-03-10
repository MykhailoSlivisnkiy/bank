package com.bank.application.security.config;

import com.bank.application.config.SecurityConfig;
import com.bank.application.security.filters.JwtAuthenticationFilter;
import com.bank.application.security.filters.JwtUserAndPasswordAuthenticationFilter;
import com.bank.application.security.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
    private final ApplicationUserService userService;
    private final SecurityConfig securityConfig;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUserAndPasswordAuthenticationFilter(authenticationManager(), securityConfig))
                .addFilterAfter(new JwtAuthenticationFilter(), JwtUserAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers( "/users/employees").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/users/clients",
                        "/users/employees",
                        "/accounts"
//                        "/users"
                ).hasRole("ADMIN")
//                .antMatchers(
//                        HttpMethod.POST,
//                        "/users"
//                ).hasRole("ADMIN")
                .antMatchers(
                        HttpMethod.DELETE,
                        "/users"
                ).hasRole("ADMIN")
//                .antMatchers(
//                        HttpMethod.POST,
//                        "users/"
//                ).permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
    }

}
