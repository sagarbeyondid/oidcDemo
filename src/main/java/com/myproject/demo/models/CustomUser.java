package com.myproject.demo.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    private String userId;
    private String accessToken;
    private String idToken;
    private String sessionId;
    private String name;
    private String email;
    private String nickName;
    private String preferredUserName;
    private String givenName;
    private String familyName;
    private String updatedAt;
    private String emailVerified;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities,
                      String userId, String accessToken, String idToken, String sessionId, String name, String email,
                      String nickName, String preferredUserName, String givenName, String familyName, String updatedAt,
                      String emailVerified) {
        super(username, password, authorities);
        this.userId = userId;
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.sessionId = sessionId;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.preferredUserName = preferredUserName;
        this.givenName = givenName;
        this.familyName = familyName;
        this.updatedAt = updatedAt;
        this.emailVerified = emailVerified;
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
                      boolean credentialsNonExpired, boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities, String userId, String accessToken,
                      String idToken, String sessionId, String name, String email, String nickName,
                      String preferredUserName, String givenName, String familyName, String updatedAt, String emailVerified) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.accessToken = accessToken;
        this.idToken = idToken;
        this.sessionId = sessionId;
        this.name = name;
        this.email = email;
        this.nickName = nickName;
        this.preferredUserName = preferredUserName;
        this.givenName = givenName;
        this.familyName = familyName;
        this.updatedAt = updatedAt;
        this.emailVerified = emailVerified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPreferredUserName() {
        return preferredUserName;
    }

    public void setPreferredUserName(String preferredUserName) {
        this.preferredUserName = preferredUserName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(String emailVerified) {
        this.emailVerified = emailVerified;
    }
}
