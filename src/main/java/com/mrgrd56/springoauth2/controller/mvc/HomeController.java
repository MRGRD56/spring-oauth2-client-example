package com.mrgrd56.springoauth2.controller.mvc;

import com.mrgrd56.springoauth2.auth.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final AuthService authService;

    public HomeController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String index(@ModelAttribute(name = "model") ModelMap model) {
        var userInfo = authService.getUserInfo();
        model.addAttribute("userInfo", userInfo);
        return "index";
    }
}
