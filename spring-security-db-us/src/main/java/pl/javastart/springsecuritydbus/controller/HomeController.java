package pl.javastart.springsecuritydbus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "homepage";
    }

    @RequestMapping("/secured")
    public String secured(){
        return "secured";
    }
}
