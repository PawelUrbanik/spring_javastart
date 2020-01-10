package pl.javastart.springmvcrestdata.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.javastart.springmvcrestdata.model.City;
import pl.javastart.springmvcrestdata.repository.CityRepository;

import java.net.URI;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityControllerRest {

    private CityRepository cityRepository;

    @Autowired
    public CityControllerRest(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<City> getCities(@RequestParam(defaultValue = "name") String orderBy)
    {
        List<City> cities = cityRepository.findAll();
        if ("name".equals(orderBy))
        {
            cities.sort(Comparator.comparing(City::getName));
        }
        else if ("population".equals(orderBy)){
            cities.sort(Comparator.comparing(City::getPopulation));
        }
        return cities;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCity(@PathVariable Long id)
    {
        return cityRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCity(@RequestBody City city)
    {
        cityRepository.save(city);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cityRepository.count())
                .toUri();
        return ResponseEntity.created(location).body(city);
    }
}
