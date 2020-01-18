package pl.javastart.springvalidatormessages.validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.javastart.springvalidatormessages.constraint.Divided;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberDivideValidator implements ConstraintValidator<Divided, Integer> {

    private int divier;


    @Override
    public void initialize(Divided constraintAnnotation) {
        this.divier = constraintAnnotation.by();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return integer%divier==0;
    }
}
