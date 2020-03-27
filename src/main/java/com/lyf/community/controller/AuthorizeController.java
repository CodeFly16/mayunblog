package com.lyf.community.controller;

import com.lyf.community.pojo.AccessTokenPOJO;
import com.lyf.community.provider.GithubProvider;
import com.lyf.community.provider.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenPOJO accessTokenPOJO = new AccessTokenPOJO();
        accessTokenPOJO.setClient_id("dc1a97ba4765459476bd");
        accessTokenPOJO.setClient_secret("d277e15b7c2460d475a2444807825dc27a679e02");
        accessTokenPOJO.setCode(code);
        accessTokenPOJO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenPOJO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenPOJO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }


}
