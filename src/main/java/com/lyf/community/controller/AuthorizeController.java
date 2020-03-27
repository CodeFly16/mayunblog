package com.lyf.community.controller;

import com.lyf.community.pojo.AccessTokenPOJO;
import com.lyf.community.provider.GithubProvider;
import com.lyf.community.provider.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenPOJO accessTokenPOJO = new AccessTokenPOJO();
        accessTokenPOJO.setClient_id(clientId);
        accessTokenPOJO.setClient_secret(clientSecret);
        accessTokenPOJO.setCode(code);
        accessTokenPOJO.setRedirect_uri(redirectUri);
        accessTokenPOJO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenPOJO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }


}
