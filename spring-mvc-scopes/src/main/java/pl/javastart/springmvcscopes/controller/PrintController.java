package pl.javastart.springmvcscopes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.springmvcscopes.component.ShoppingCartComponent;

@Controller
public class PrintController {

    private ShoppingCartComponent cart;

    @Autowired
    public PrintController (ShoppingCartComponent cart){
        this.cart = cart;
    }

    @GetMapping("/print")
    public String printCart()
    {
        cart.getProducts().forEach(System.out::println);
        return "homepage";
    }
}
