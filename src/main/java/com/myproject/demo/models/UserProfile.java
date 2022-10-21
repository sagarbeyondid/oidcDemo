package com.myproject.demo.models;

import javax.validation.constraints.NotEmpty;

public class UserProfile {

    @NotEmpty(message = "First name cannot be left blank")
    private String firstName;

    @NotEmpty(message = "Last name cannot be left blank")
    private String lastName;

    @NotEmpty(message = "Email cannot be left blank")
    private String email;

    @NotEmpty(message = "Username cannot be left blank")
    private String login;
    private String mobilePhone;

//    private String password;
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public UserProfile(String firstName, String lastName, String email, String login, String mobilePhone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.mobilePhone = mobilePhone;
//        this.password = password;
    }

    public UserProfile() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
