package com.bank.application.security.config;

import com.bank.application.config.SecurityConfig;
import com.bank.application.security.filters.JwtAuthenticationFilter;
import com.bank.application.security.filters.JwtUserAndPasswordAuthenticationFilter;
import com.bank.application.security.jwt.JwtTokenProvider;
import com.bank.application.security.service.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService userService;
    private final SecurityConfig securityConfig;
    private final JwtTokenProvider tokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUserAndPasswordAuthenticationFilter(authenticationManager(), securityConfig, tokenProvider))
                .addFilterAfter(new JwtAuthenticationFilter(securityConfig), JwtUserAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers( "/users/employees").permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/users/clients",
                        "/users/employees"
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
                .and()
                .authorizeRequests().antMatchers("/users/login").permitAll()
                .anyRequest()
                .authenticated();
//                .and()
//                .formLogin();
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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
