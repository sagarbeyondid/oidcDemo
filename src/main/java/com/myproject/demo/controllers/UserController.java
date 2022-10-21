package com.myproject.demo.controllers;

import com.myproject.demo.models.UserDto;
import com.myproject.demo.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/register", params = "activate")
    public Map<String, Object> userRegistration(@Valid @RequestBody UserDto user, BindingResult bindingResult,
                                                @RequestParam("activate") Boolean activate) throws Exception {

        if(!bindingResult.hasErrors()) {
            try {
                if (user.getCredentials() == null) {
                    if (user.getGroupIds() != null) {
                        return userService.createUserInGroup(user, activate);
                    }
                    return userService.createUserWithoutCredentials(user, activate);
                }
                if (user.getCredentials().getPassword() != null) {
                    if (user.getCredentials().getRecoveryQuestion() != null) {
                        return userService.createUserWithPwdAndRecoveryQuestion(user, activate);
                    } else {
                        return userService.createUserWithPwd(user, activate);
                    }
                }
                if (user.getCredentials().getRecoveryQuestion() != null) {
                    return userService.createUserWithRQ(user, activate);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }else throw new Exception("Primary fields not provided.");
        return null;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
