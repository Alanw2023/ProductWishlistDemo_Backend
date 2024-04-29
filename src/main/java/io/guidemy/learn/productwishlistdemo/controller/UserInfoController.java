package io.guidemy.learn.productwishlistdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/user-info")
public class UserInfoController {
    @GetMapping()
    public Map<String, String> getUserInfo (Principal principal){
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        return Map.of(
                "displayName",token.getTokenAttributes().get("name").toString(),
                "email", token.getTokenAttributes().get("email").toString(),
                "firebaseUID",token.getTokenAttributes().get("user_id").toString(),
                "roles",token.getTokenAttributes().get("custom_claims").toString()
        );
    }
}
