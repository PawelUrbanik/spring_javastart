package pl.javastart.springmvcthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.springmvcthymeleaf.model.Article;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("helloMessage", "Hello Message");
        model.addAttribute("formArticle", new Article("Title", "Some content", "tag1, tag2"));
        return "index";
    }
}
