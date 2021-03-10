package com.bank.application.security.filters;

import com.bank.application.config.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class JwtUserAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final SecurityConfig securityConfig;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Map<String, String> params = new HashMap<>();

            Map<String, String[]> parameterMap = request.getParameterMap();
            parameterMap.forEach((key,value) -> { params.put(key, value[0]); });
            String json = String.format( "{ \"username\" : \"%s\", \"password\" : \"%s\" }", parameterMap.get("username")[0], parameterMap.get("password")[0]);
            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper().readValue(json, UsernameAndPasswordAuthenticationRequest.class);

//            UsernameAndPasswordAuthenticationRequest authenticationRequest = new ObjectMapper()
//                    .readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),
                    authenticationRequest.getPassword());

            return authenticationManager.authenticate(authentication);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new java.util.Date())
                .setExpiration(Date.valueOf(LocalDate.now().plusWeeks(securityConfig.getExpiration())))
                .signWith(securityConfig.getSecretKey())
                .compact();
        response.addHeader(securityConfig.getHeader(), securityConfig.getTokenPrefix() + token);
    }
}

