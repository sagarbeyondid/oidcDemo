package com.myproject.demo.models;

import java.util.Date;
import java.util.List;

public class UserDto {

    private String id;
    private String status;
    private Date created;
    private Date lastUpdated;
    private Date statusChanged;
    private Date activated;
    private Date lastLogin;
    private Date passwordChanged;

    private UserProfile profile;
    private Credentials credentials;

    private List<String> groupIds;
    private Links _links;

    public UserDto() {
    }

    public UserDto(String id, String status, Date created, Date lastUpdated, Date statusChanged,
                   Date activated, Date lastLogin, Date passwordChanged, UserProfile profile,
                   Credentials credentials, List<String> groupIds, Links _links) {
        this.id = id;
        this.status = status;
        this.created = created;
        this.lastUpdated = lastUpdated;
        this.statusChanged = statusChanged;
        this.activated = activated;
        this.lastLogin = lastLogin;
        this.passwordChanged = passwordChanged;
        this.profile = profile;
        this.credentials = credentials;
        this.groupIds = groupIds;
        this._links = _links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getStatusChanged() {
        return statusChanged;
    }

    public void setStatusChanged(Date statusChanged) {
        this.statusChanged = statusChanged;
    }

    public Date getActivated() {
        return activated;
    }

    public void setActivated(Date activated) {
        this.activated = activated;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(Date passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
    }

    public Links get_links() {
        return _links;
    }

    public void set_links(Links _links) {
        this._links = _links;
    }
}
