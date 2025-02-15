package org.easytravel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/req/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/req/signup")
    public String Signup()
    {
        return "signup";
    }

    @GetMapping("/index")
    public String Index()
    {
        return "index";
    }
}
