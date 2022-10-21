package com.myproject.demo.serviceImpl;

import com.myproject.demo.services.OktaHelperService;
import com.myproject.demo.utils.OktaConfigProperties;
import com.myproject.demo.utils.OktaUrlConstant;
import com.okta.commons.lang.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OktaHelperServiceImpl implements OktaHelperService {

    @Autowired
    private OktaConfigProperties oktaConfigProperties;

    @Override
    public String getAuthorizationCode(String sessionToken, String state, String idp, String nonce) {
        String url = oktaConfigProperties.getOrgUrl() + OktaUrlConstant.AUTHORIZE_URL + "?client_id="
                + oktaConfigProperties.getClientId() + "&response_type=code&scope=" + oktaConfigProperties.getScopes()
                + "&redirect_uri=" + oktaConfigProperties.getRedirectUri() + "&state=" + state
                + "&nonce="+nonce+"&";

        if(!Strings.isEmpty(sessionToken)) {
            url += "sessionToken=" + sessionToken;
        }
        if(Strings.isEmpty(idp)){
            url += "idp=" + idp;
        }
        return url;
    }
}
