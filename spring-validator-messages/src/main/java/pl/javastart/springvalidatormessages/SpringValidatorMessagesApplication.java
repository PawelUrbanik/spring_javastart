package pl.javastart.springvalidatormessages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.springvalidatormessages.model.NumerBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;


@SpringBootApplication
public class SpringValidatorMessagesApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorMessagesApplication.class, args);
        Locale.setDefault(Locale.ENGLISH);
        Validator validator = ctx.getBean(Validator.class);
        NumerBean numerBean = new NumerBean(10);
        Set<ConstraintViolation<NumerBean>> errors = validator.validate(numerBean);
        errors.forEach(err -> System.out.println(err.getMessage()));
        ctx.close();
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }

}
