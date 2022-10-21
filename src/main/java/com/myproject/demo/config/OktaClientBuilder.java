package com.myproject.demo.config;

import com.myproject.demo.utils.OktaConfigProperties;
import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OktaClientBuilder {

    @Autowired
    private OktaConfigProperties oktaConfigProperties;

    public Client client(){

        return Clients.builder().setOrgUrl(oktaConfigProperties.getOrgUrl())
                .setClientCredentials(new TokenClientCredentials(oktaConfigProperties.getToken()))
                .build();
    }

}
