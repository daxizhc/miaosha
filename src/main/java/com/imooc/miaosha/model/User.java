package com.imooc.miaosha.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Integer id;

    private String name;

    private Integer age;

}
