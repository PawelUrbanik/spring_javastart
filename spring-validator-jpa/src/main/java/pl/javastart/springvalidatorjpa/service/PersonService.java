package pl.javastart.springvalidatorjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import pl.javastart.springvalidatorjpa.model.Person;
import pl.javastart.springvalidatorjpa.repository.PersonRepository;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Service
public class PersonService {

    PersonRepository personRepository;

    @Autowired
    public PersonService (PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person)
    {
        try
        {
            personRepository.add(person);
        } catch (ConstraintViolationException e) {
            Set<ConstraintViolation<?>> errors = e.getConstraintViolations();
            errors.forEach(err-> System.err.println(
                    err.getPropertyPath() + " "+
                    err.getInvalidValue()  + " " +
                            err.getInvalidValue()
            ));
        }
    }
}
