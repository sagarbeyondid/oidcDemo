package com.myproject.demo.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.demo.models.CustomUser;
import com.myproject.demo.utils.OktaConfigProperties;
import com.myproject.demo.utils.OktaUrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@Component
public class CustomAuthProvider implements AuthenticationProvider {

    @Autowired
    private OktaConfigProperties oktaConfigProperties;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        RestTemplate restTemplate = new RestTemplate();

        CustomAuthenticationToken authToken = (CustomAuthenticationToken) authentication;

        String url = oktaConfigProperties.getIssuer() + "/v1/token?client_id=" + oktaConfigProperties.getClientId()
                + "&client_secret=" + oktaConfigProperties.getClientSecret() + "&redirect_uri="
                + oktaConfigProperties.getRedirectUri() + "&grant_type=authorization_code&code="
                + authToken.getAuthorizationCode();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        try{
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            ObjectMapper obj = new ObjectMapper();

            Map<String, Object> accessToken = obj.readValue(responseEntity.getBody(), new TypeReference<Map<String,Object>>(){});

            if (accessToken.containsKey("access_token")){
                Map<String, Object> userInfo = getUserinfo(accessToken.get("access_token").toString());

                CustomUser customUser = new CustomUser(userInfo.containsKey("email") ? String.valueOf(userInfo.get("email")) : "", "",
                        new ArrayList<>(), userInfo.get("sub").toString(), accessToken.get("access_token").toString(),
                        accessToken.get("id_token").toString(), authToken.getState(),
                        userInfo.containsKey("name") ? String.valueOf(userInfo.get("name")): "",

                        userInfo.containsKey("email") ? String.valueOf(userInfo.get("email")) : "",
                        userInfo.containsKey("nickname") ? String.valueOf(userInfo.get("nickname")) : "",
                        StringUtils.isEmpty(userInfo.get("preferred_username")) ? "" :
                                userInfo.get("preferred_username").toString(),
                        userInfo.get("given_name").toString(),
                        StringUtils.isEmpty(userInfo.get("family_name")) ? "" : userInfo.get("family_name").toString(),
                        userInfo.get("updated_at").toString(), userInfo.get("email_verified").toString());
                return new UsernamePasswordAuthenticationToken(customUser, null,null);
            }
        }
        catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

    private Map<String, Object> getUserinfo(String access_token) throws JsonProcessingException {
        String url = oktaConfigProperties.getIssuer() + OktaUrlConstant.USERINFO_URL;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + access_token);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        ObjectMapper obj = new ObjectMapper();
        return obj.readValue(responseEntity.getBody(), new TypeReference<Map<String, Object>>() {
            });
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
