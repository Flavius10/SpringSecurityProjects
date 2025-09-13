package com.example.ssiach2_.ex2.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if("Flavius".equals(username) && "password".equals(password)){
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    Arrays.asList()
            );
        }else{
            throw new AuthenticationCredentialsNotFoundException("Invalid credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType){
        return UsernamePasswordAuthenticationToken
                .class
                .isAssignableFrom(authenticationType);
    }

}
