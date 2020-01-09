package pl.javastart.springmvcrestjaxb.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.javastart.springmvcrestjaxb.model.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private List<City> cities;

    public CityController() {
        this.cities = Collections.synchronizedList(new ArrayList<City>());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(@RequestParam(defaultValue ="name") String orderBy)
    {
        List<City> copyCities = new ArrayList<>(cities);
        if ("name".equals(orderBy))
        {
            copyCities.sort(Comparator.comparing(City::getName));
        }
        else if ("population".equals(orderBy))
        {
            copyCities.sort(Comparator.comparing(City::getName));
        }

        return copyCities;
    }

    @GetMapping("/{id}")
    public City getCity(@PathVariable int id){
        return cities.get(id);
    }


    @PostMapping()
    public void saveCity(@RequestBody City city)
    {
        cities.add(city);
    }
}
