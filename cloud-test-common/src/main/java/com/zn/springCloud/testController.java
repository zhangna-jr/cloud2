package com.zn.springCloud;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class testController {
    public static void main(String[] args) {
        String secret = new BCryptPasswordEncoder().encode("secret");
        String secret1 = BCrypt.hashpw("secret",BCrypt.gensalt());
        System.out.println("=============secret:"+secret);
        System.out.println("=============secret1:"+secret1);
    }
}
