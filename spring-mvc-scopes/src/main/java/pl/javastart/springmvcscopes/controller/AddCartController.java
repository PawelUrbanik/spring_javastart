package pl.javastart.springmvcscopes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.springmvcscopes.component.ShoppingCartComponent;

@Controller
public class AddCartController {

    private ShoppingCartComponent cart;

    @Autowired
    public AddCartController (ShoppingCartComponent cart)
    {
        this.cart= cart;
    }

    @PostMapping("add")
    public String addProduct(@RequestParam String product){
        cart.addProduct(product);
        System.out.println("Added: " + product);
        return "homepage";
    }
}
