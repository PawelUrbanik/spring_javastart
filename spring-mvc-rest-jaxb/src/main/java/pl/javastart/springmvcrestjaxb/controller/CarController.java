package pl.javastart.springmvcrestjaxb.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javastart.springmvcrestjaxb.model.Car;

@RestController
public class CarController {

    @GetMapping(value = "/car",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Car getCar(){
        return new Car("BMW", "X5");
    }
}
