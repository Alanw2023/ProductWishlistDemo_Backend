package io.guidemy.learn.productwishlistdemo.controller.Admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/admin/info")
public class AdminTestController {
    @GetMapping()
    public Map<String, String> getAdminInfo (Principal principal){
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        return Map.of(
                "displayName",token.getTokenAttributes().get("name").toString(),
                "email", token.getTokenAttributes().get("email").toString(),
                "firebaseUDI",token.getTokenAttributes().get("user_id").toString(),
                "roles",token.getTokenAttributes().get("custom_claims").toString()
        );
    }
}
