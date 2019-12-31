package pl.javastart.springmvcthymeleafmore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.springmvcthymeleafmore.model.Book;

import java.util.Arrays;

@Controller
public class AppController {


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("book", new Book());
        return "home";
    }


    @GetMapping("/if")
    public String ifPage(Model model){
        model.addAttribute("a", 10);
        model.addAttribute("b", 60);
        model.addAttribute("text", "Przykładowy tekst");
        return "if";
    }

    @GetMapping("/loop")
    public String loopPage(Model model)
    {
        model.addAttribute("books", Arrays.asList(
                new Book("W pus", "stas", 33.2),
                new Book("W pusss", "stassad", 23.2),
                new Book("W pustun", "stasasd", 33.2),
                new Book("W pusasdzz", "stasada", 53.2)
        ));
        return "loop";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book, Model model)
    {
        model.addAttribute("message", "Book " + book + " was added");
        return "home";
    }
}
