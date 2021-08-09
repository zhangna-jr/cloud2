package com.zn.springCloud.security.distributed.uaaOrder.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("r")
public class OrderController {

    @GetMapping("/r1")
    @PreAuthorize("hasAnyAuthority('p3')")
    public String r1(){
        return "访问资源1";
    }
}
