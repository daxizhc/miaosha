package com.imooc.miaosha.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public <T> T get(String key, Class<T> clazz){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String json = operations.get(key);
        if(StringUtils.isEmpty(json)){
            return null;
        }else {
            return new Gson().fromJson(json, clazz);
        }
    }

    public <T> boolean set(String key, T value){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set(key, new Gson().toJson(value));
        return true;
    }

}
