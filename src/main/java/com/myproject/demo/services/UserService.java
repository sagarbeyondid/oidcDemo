package com.myproject.demo.services;

import com.myproject.demo.models.UserDto;

import java.util.Map;

public interface UserService {

    public Map<String, Object> createUserWithPwdAndRecoveryQuestion(UserDto userDto, Boolean activate);
    public Map<String, Object> createUserWithoutCredentials(UserDto userDto, Boolean activate);
    public Map<String, Object> createUserWithPwd(UserDto userDto, Boolean activate);
    public Map<String, Object> createUserWithRQ(UserDto userDto, Boolean activate);
    public Map<String, Object> createUserInGroup(UserDto userDto, Boolean activate);
    public Map<String, Object> createUserWithNonDefaultUserType(UserDto userDto);


}
