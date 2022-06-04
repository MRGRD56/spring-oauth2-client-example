package com.mrgrd56.springoauth2.controller;

import com.mrgrd56.springoauth2.auth.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("private")
public class PrivateController {
    private final AuthService authService;

    public PrivateController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public Object get() {
        return Map.ofEntries(
                Map.entry("info", "This is a private page, you can't visit it if you aren't logged in"),
                Map.entry("access_token", authService.getAccessToken())
        );
    }
}
