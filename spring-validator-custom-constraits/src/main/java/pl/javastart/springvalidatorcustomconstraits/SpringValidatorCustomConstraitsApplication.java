package pl.javastart.springvalidatorcustomconstraits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.springvalidatorcustomconstraits.model.Message;
import pl.javastart.springvalidatorcustomconstraits.service.MessageService;

import javax.validation.Validator;

@SpringBootApplication
public class SpringValidatorCustomConstraitsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorCustomConstraitsApplication.class, args);

        MessageService messageService = ctx.getBean(MessageService.class);
        Message message = new Message("Hello Message", "No kurwa");
        boolean verifyMessage = messageService.verifyMessage(message);
        System.out.println("Wiadomość poprawna ? : " + verifyMessage);
        ctx.close();
    }

    @Bean
    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
