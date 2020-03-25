package com.imooc.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.miaosha.model.User;
import com.imooc.miaosha.redis.RedisService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/redisSetAndGet")
    public User redisSetAndGet(){
        User user_1 = User.builder().id(1).name("user_1").age(11).build();
        redisService.set("user_1", user_1);
        return redisService.get("user_1", User.class);
    }

}
