package pl.javastart.springsecurityformthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/secret")
    public String secret(){
        return "secure";
    }

    @RequestMapping("/loginform")
    public String loginForm(){
        return "login_form";
    }
}
