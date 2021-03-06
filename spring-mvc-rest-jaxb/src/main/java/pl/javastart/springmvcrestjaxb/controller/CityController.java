package pl.javastart.springmvcrestjaxb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javastart.springmvcrestjaxb.model.City;

import java.net.URI;
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


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCity(@RequestBody City city)
    {
        if (!cities.contains(city))
        {
            cities.add(city);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(cities.size()-1)
                    .toUri();
            return ResponseEntity.created(location).body(city);
        } else
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
