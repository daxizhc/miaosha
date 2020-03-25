package com.imooc.miaosha.redis;

public class BaseKeyPrefix implements KeyPrefix {

    @Override
    public int expireSeconds() {
        return 0;
    }

    @Override
    public String getPrefix() {
        return null;
    }
}
