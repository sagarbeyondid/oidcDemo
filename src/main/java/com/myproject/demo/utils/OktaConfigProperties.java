package com.myproject.demo.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "okta.oauth2")
@PropertySource("classpath:application.yml")
public class OktaConfigProperties {

    private String clientId;
    private String clientSecret;
    private String orgUrl;
    private String redirectUri;
    private String issuer;
    private String token;
    private String logOutRedirectUri;
    private String scopes;

    public OktaConfigProperties() {
    }

    public OktaConfigProperties(String clientId, String clientSecret, String orgUrl, String redirectUri, String issuer,
                                String token, String logOutRedirectUri, String scopes) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.orgUrl = orgUrl;
        this.redirectUri = redirectUri;
        this.issuer = issuer;
        this.token = token;
        this.logOutRedirectUri = logOutRedirectUri;
        this.scopes = scopes;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getOrgUrl() {
        return orgUrl;
    }

    public void setOrgUrl(String orgUrl) {
        this.orgUrl = orgUrl;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLogOutRedirectUri() {
        return logOutRedirectUri;
    }

    public void setLogOutRedirectUri(String logOutRedirectUri) {
        this.logOutRedirectUri = logOutRedirectUri;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }
}