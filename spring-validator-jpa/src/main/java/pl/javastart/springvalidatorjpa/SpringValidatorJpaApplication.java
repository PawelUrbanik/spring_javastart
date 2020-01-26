package pl.javastart.springvalidatorjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.TransactionSystemException;
import pl.javastart.springvalidatorjpa.model.Person;
import pl.javastart.springvalidatorjpa.repository.PersonRepository;
import pl.javastart.springvalidatorjpa.service.PersonService;

@SpringBootApplication
public class SpringValidatorJpaApplication {

    public static void main(String[] args) throws InterruptedException {
      ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorJpaApplication.class, args);
        PersonService personService = ctx.getBean(PersonService.class);
        Person person = new Person("Pawel", "urb", "pawepawel.eu", 10 );
        personService.addPerson(person);
        Thread.sleep(10000);
      //ctx.close();
    }

}
