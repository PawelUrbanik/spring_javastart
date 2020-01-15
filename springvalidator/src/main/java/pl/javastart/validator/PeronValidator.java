package pl.javastart.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pl.javastart.model.Person;


@Component
public class PeronValidator implements Validator {

    private static final int MIN_AGE=1;

    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

        Person person = (Person) o;
        checkEmail(person,errors);
        checkAge(person, errors);
    }

    private void checkAge(Person person, Errors errors) {
        if (person.getAge() < MIN_AGE)
        {
            errors.rejectValue("age", "invalid");
        }
    }

    private void checkEmail(Person person, Errors errors) {
        if (person.getEmail() == null){
            errors.rejectValue("email", "required");
        }else if (!person.getEmail().contains("@")){
            errors.rejectValue("email", "invalid");
        }
    }
}
