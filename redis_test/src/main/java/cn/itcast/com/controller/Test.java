package cn.itcast.com.controller;

import cn.itcast.com.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @Autowired
    private RedisService redisService;
    @RequestMapping("test")
    public String test(){
        redisService.setString("XXX","你好");
        return "你好";
    }
}
