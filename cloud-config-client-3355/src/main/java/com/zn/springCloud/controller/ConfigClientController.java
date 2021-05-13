package com.zn.springCloud.controller;

import com.zn.springCloud.entities.CommentResule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //刷新节点
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping(value = "/configInfo")
    public CommentResule configInfo(){
        return new CommentResule(0000,"读取config成功",configInfo);
    }
}
