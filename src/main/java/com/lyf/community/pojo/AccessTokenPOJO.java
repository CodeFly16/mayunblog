package com.lyf.community.pojo;

import lombok.Data;

@Data
public class AccessTokenPOJO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;


}
