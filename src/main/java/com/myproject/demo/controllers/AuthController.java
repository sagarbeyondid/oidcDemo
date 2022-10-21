package com.myproject.demo.controllers;

import com.myproject.demo.services.OktaHelperService;
import com.myproject.demo.utils.OktaConfigProperties;
import com.okta.commons.lang.Strings;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OktaConfigProperties oktaConfigProperties;

    @Autowired
    private OktaHelperService oktaHelperService;

    @PostMapping({"/signin","/login"})
    public String loginPage(HttpServletRequest request, HttpServletResponse response) {
        String stateToken = RandomStringUtils.randomAlphanumeric(10);
        String nonce = RandomStringUtils.randomAlphabetic(10);
        Cookie cookie = new Cookie("okta-oauth-state", stateToken);
        Cookie nonceCookie = new Cookie("okta-auth-nonce", nonce);
        response.addCookie(nonceCookie);
        response.addCookie(cookie);

        if(!Strings.isEmpty(request.getParameter("sessionToken"))) {

            String result = oktaHelperService.getAuthorizationCode(request.getParameter("sessionToken"), stateToken,
                    "", nonce);
            return result;
        } else if (!Strings.isEmpty(request.getParameter("sessionId"))) {

            String result = oktaHelperService.getAuthorizationCode(null, stateToken, "", nonce);
            return result;
        }
        return null;
    }
}
