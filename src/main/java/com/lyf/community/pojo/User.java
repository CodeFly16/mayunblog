package com.lyf.community.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModifier;
    private String avatarUrl;
}
