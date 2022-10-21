package com.myproject.demo.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.demo.models.UserDto;
import com.myproject.demo.services.UserService;
import com.myproject.demo.utils.OktaConfigProperties;
import com.myproject.demo.utils.OktaUrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private OktaConfigProperties oktaConfigProperties;

    @Override
    public Map<String, Object> createUserWithPwdAndRecoveryQuestion(UserDto userDto, Boolean activate) {

        HttpHeaders headers = getHeaders();

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("profile", userDto.getProfile());

        Map<String, Object> map = new HashMap<>();
        map.put("password", userDto.getCredentials().getPassword());
        map.put("recovery_question", userDto.getCredentials().getRecoveryQuestion());
        requestBody.put("credentials", map);

        return createUser(userDto,activate, requestBody, headers);
    }

    @Override
    public Map<String, Object> createUserWithoutCredentials(UserDto userDto, Boolean activate) {
        HttpHeaders headers = getHeaders();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("profile", userDto.getProfile());
        return createUser(userDto, activate, requestBody, headers);
    }

    @Override
    public Map<String, Object> createUserWithPwd(UserDto userDto, Boolean activate) {
        HttpHeaders headers = getHeaders();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("profile", userDto.getProfile());

        Map<String, Object> map = new HashMap<>();
        map.put("password", userDto.getCredentials().getPassword());
        requestBody.put("credentials", map);

        return createUser(userDto, activate, requestBody, headers);
    }

    @Override
    public Map<String, Object> createUserWithRQ(UserDto userDto, Boolean activate) {
        HttpHeaders headers = getHeaders();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("profile", userDto.getProfile());

        Map<String, Object> map = new HashMap<>();
        map.put("recovery_question", userDto.getCredentials().getRecoveryQuestion());
        requestBody.put("credentials", map);

        return createUser(userDto, activate, requestBody, headers);
    }

    @Override
    public Map<String, Object> createUserInGroup(UserDto userDto, Boolean activate) {
        HttpHeaders headers = getHeaders();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("profile", userDto.getProfile());
        requestBody.put("groupIds", userDto.getGroupIds());
        return createUser(userDto, activate, requestBody, headers);
    }

    @Override
    public Map<String, Object> createUserWithNonDefaultUserType(UserDto userDto) {
        return null;
    }

    private Map<String, Object> createUser(UserDto userDto,Boolean activate, Map<String, Object> requestBody, HttpHeaders headers) {
        String url = oktaConfigProperties.getOrgUrl() + OktaUrlConstant.USERS_URL + "?activate=" +activate.toString();

        ObjectMapper obj = new ObjectMapper();

        RestTemplate restTemplate = new RestTemplate();

        try{
            HttpEntity<String> entity = new HttpEntity<>(obj.writeValueAsString(requestBody),headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            return obj.readValue(responseEntity.getBody(), new TypeReference<Map<String, Object>>(){} );

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","application/json");
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", "SSWS " + oktaConfigProperties.getToken());
        return headers;
    }
}
