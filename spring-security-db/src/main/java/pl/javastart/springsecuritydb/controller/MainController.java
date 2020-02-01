package pl.javastart.springsecuritydb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }
}
