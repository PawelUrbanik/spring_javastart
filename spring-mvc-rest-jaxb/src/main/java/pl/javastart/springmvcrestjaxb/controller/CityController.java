package pl.javastart.springmvcrestjaxb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javastart.springmvcrestjaxb.model.City;

@RestController
public class CityController {

    @GetMapping("/city")
    public City city(){
        return new City("Warszawa", 17);
    }
}
