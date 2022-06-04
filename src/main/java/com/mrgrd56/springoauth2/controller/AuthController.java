package com.mrgrd56.springoauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AuthController {
    @GetMapping("login")
    public Object login() {
        return new RedirectView("/oauth2/authorization/github");
    }
}
