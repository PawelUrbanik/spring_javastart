package pl.javastart.springvalidatorboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.springvalidatorboot.model.Person;
import pl.javastart.springvalidatorboot.service.PersonService;


@SpringBootApplication
public class SpringValidatorBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorBootApplication.class, args);

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

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
