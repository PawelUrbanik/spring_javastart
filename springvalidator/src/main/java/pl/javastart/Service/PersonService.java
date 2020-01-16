package pl.javastart.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import pl.javastart.model.Person;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {

    private Set<Person> people;
    private Validator validator;

    @Autowired
    public PersonService(Validator validator)
    {
        this.validator=validator;
        this.people = new HashSet<Person>();
    }

    public void addPerson(Person person)
    {
        Errors errors = new BeanPropertyBindingResult(person, "person");
        validator.validate(person, errors);
        if (errors.hasErrors()){
            System.out.printf("There are errors: %d: \n", errors.getErrorCount());
            for (ObjectError error: errors.getAllErrors())
            {
                System.out.println(error.getDefaultMessage());
            }
        }
        else {
            people.add(person);
        }
    }

    public Set<Person> getPeople(){
        return this.people;
    }


}
