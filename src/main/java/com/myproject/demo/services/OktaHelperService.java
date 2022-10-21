package com.myproject.demo.services;

public interface OktaHelperService {

    public String getAuthorizationCode(String sessionToken, String state, String idp, String nonce);
}
