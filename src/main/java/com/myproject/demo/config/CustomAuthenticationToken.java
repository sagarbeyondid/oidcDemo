package com.myproject.demo.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String authorizationCode;
    private String state;

    public CustomAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, String authorizationCode, String state) {
        super(principal, credentials);
        this.authorizationCode = authorizationCode;
        this.state = state;
    }

    public CustomAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String authorizationCode) {
        super(principal, credentials, authorities);
        this.authorizationCode = authorizationCode;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
