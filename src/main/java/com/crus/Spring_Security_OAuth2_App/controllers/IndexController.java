package com.crus.Spring_Security_OAuth2_App.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index";
    }

    @GetMapping("/protected")
    public String protectedIndex(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index";
    }

    @GetMapping("/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "error";
    }

    @GetMapping("/login")
    public String loginExpired(@RequestParam(required = false) String expired, Model model) {
        if ("true".equals(expired)) {
            model.addAttribute("loginExpired", true);
        }
        return "login";
    }
}
