package pl.javastart.springmvcjstl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.springmvcjstl.model.Article;

import java.util.stream.Stream;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model)
    {
        model.addAttribute("helloMessage", "Hello! :)");
        model.addAttribute("formArticle", new Article("Some title", "Some Content", "tag1, tag2"));
        return "home";

    }
}
