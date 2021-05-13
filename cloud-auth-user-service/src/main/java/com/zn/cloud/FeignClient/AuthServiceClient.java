package com.zn.cloud.FeignClient;

import com.zn.cloud.dao.JWT;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
//@FeignClient(value = "auth-service", fallback = AuthServiceHystrix.class)
@FeignClient(value = "auth-service")
public interface AuthServiceClient {

    @PostMapping(value = "/oauth/token")
    JWT getToken(@RequestHeader(name = "Authorization") String authorization,
                 @RequestParam("grant_type") String type,
                 @RequestParam("username") String username,
                 @RequestParam("password") String password);
}
