package pl.javastart.springvalidatorcustomconstraits.constraint;


import pl.javastart.springvalidatorcustomconstraits.common.Lang;
import pl.javastart.springvalidatorcustomconstraits.validator.BadWordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {BadWordValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBadWord {

    String message() default "You cannot use bad words in your messages";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Lang[] lang() default Lang.PL;
}
