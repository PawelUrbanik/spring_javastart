package pl.javastart.springmvccalc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String home (@RequestParam(defaultValue = "Nieznajomy") String username,
//                        @RequestParam(defaultValue = "") int age,
//                        @RequestHeader("user-agent") String userAgent){
//        System.out.println("username: "+ username + ", age: " + age);
//        System.out.println("user agent: " + userAgent);
//        return "home";
//    }
    @PostMapping("/")
    public String calculate(@RequestParam(defaultValue= "1") int valueA,
                            @RequestParam(defaultValue = "1") int valueB)
    {
        int result  = valueA + valueB;
        System.out.printf("%d + %d = %d", valueA, valueB, result);
        return "home";
    }

    @GetMapping("/")
    public String home()
    {
        return "home";
    }


}
