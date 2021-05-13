package com.zn.cloud.FeignClient;

import com.zn.cloud.dao.JWT;
import com.zn.cloud.dao.JWTReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient{

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceHystrix.class);

    @Override
    public JWT getToken(String Authorization, String type, String username, String password) {
        return null;
    }
}
