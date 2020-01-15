package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pl.javastart.Service.PersonService;
import pl.javastart.model.Person;

@ComponentScan
@Configuration
public class SpringValidatorApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringValidatorApp.class);


        PersonService personService = ctx.getBean(PersonService.class);
        Person person1 = new Person("Jan", "Kowalski", "jan@kowalski.org", 35);
        System.out.println("Adding " + person1);
        personService.addPerson(person1);

        Person person2 = new Person("Paweł", "Ands", "pawelss", 32);
        System.out.println("Adding " + person2);
        personService.addPerson(person2);

        System.out.println("Person size: " + personService.getPeople().size());
        personService.getPeople().forEach(System.out::println);

        ctx.close();
    }

}
