package pl.javastart.springmvcdispatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.springmvcdispatch.component.EventHolder;
import pl.javastart.springmvcdispatch.model.Participant;

@Controller
public class EventController {

     private EventHolder eventHolder;

     public EventController(EventHolder eventHolder)
     {
         this.eventHolder = eventHolder;
     }

    @PostMapping("/register")
    public String register(@RequestParam String firstname, @RequestParam String lastname)
    {
        Participant participant = new Participant(firstname, lastname);
        if (eventHolder.checkRegistration(participant))
        {
            return "redirect:bad";
        }
        else {
            eventHolder.addParticipant(participant);
            return "redirect:succes";
        }
    }

    @GetMapping("/succes")
    public String succes()
    {
        return "succes";
    }

    @GetMapping("/bad")
    public String error(){
         return "bad";
    }

    @GetMapping("/show")
    public String showParticipants(){
        eventHolder.getParticipants().forEach(System.out::println);
        return "redirect:/";
    }
}
