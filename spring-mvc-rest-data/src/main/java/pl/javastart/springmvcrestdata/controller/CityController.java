package pl.javastart.springmvcrestdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.javastart.springmvcrestdata.model.City;
import pl.javastart.springmvcrestdata.repository.CityRepository;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityController {

    private CityRepository cityRepository;

    @Autowired
    public CityController(CityRepository cityRepository)
    {
        this.cityRepository=  cityRepository;
    }

    @GetMapping
    public String getCities(Model model)
    {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "list";
    }

    @PostMapping
    public String saveCity(@ModelAttribute City city, RedirectAttributes redirectAttributes)
    {
        cityRepository.save(city);
        String message = "City " + city.getName() + " with population " + city.getPopulation() + " added succesfully";
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
