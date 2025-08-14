package com.crus.Spring_Security_OAuth2_App.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
