package com.zn.cloud.controller;


import com.zn.cloud.entity.TUser;
import com.zn.cloud.service.AuthUserService;
import com.zn.springCloud.entities.CommentResule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @RequestMapping(value = "/register")
    public CommentResule register(@RequestBody TUser user){
        user.setUserPassword(new BCryptPasswordEncoder().encode(user.getUserPassword()));
        CommentResule value = authUserService.register(user);
        return value;
    }

    @RequestMapping(value = "/loginSuccess")
    public CommentResule loginSuccess(){
        //获取验证通过的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails){
            String username = ((UserDetails) principal).getUsername();
            String password = ((UserDetails) principal).getPassword();
            Collection<? extends GrantedAuthority> authorities = ((UserDetails) principal).getAuthorities();
            return new CommentResule(200,"成功",username);
        }
        return new CommentResule(500,"失败",null);

    }

   /* @RequestMapping(value = "/login")
    public UserLoginDTO login(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        UserLoginDTO userLoginDTO = authUserService.login(username,password);
        return userLoginDTO;
    }*/

    @RequestMapping(value = "/foo", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('张三')")
    public String getFoo() {
        return "i'm foo, " + UUID.randomUUID().toString();
    }
}
