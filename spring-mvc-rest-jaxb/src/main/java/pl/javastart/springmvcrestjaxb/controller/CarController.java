package pl.javastart.springmvcrestjaxb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javastart.springmvcrestjaxb.model.Car;

@RestController
public class CarController {

    @GetMapping("/car")
    public Car getCar(){
        return new Car("BMW", "X5");
    }
}
