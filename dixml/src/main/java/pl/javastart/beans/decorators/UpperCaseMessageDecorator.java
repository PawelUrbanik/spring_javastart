package pl.javastart.beans.decorators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.javastart.beans.decorators.MessageDecorator;

@Component
@Decorator(type = Decorator.DecoratorType.UPPER)
public class UpperCaseMessageDecorator implements MessageDecorator {

    public String decorate(String msg) {
        return msg.toUpperCase();
    }
}
