package pl.javastart.springsecuritycsrf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }


    @PostMapping("/calculate")
    @ResponseBody
    public String calculate(@RequestParam int a, @RequestParam int b)
    {
        return String.format("%d, %d, %d", a,b,(a+b));
    }
}
