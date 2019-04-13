package pl.javastart.beans.decorators;

import org.springframework.stereotype.Component;

@Component
@Decorator(type = Decorator.DecoratorType.LOWER)
public class LowerCaseMessageDecorator implements MessageDecorator {

    public String decorate(String msg) {
        return msg.toLowerCase();
    }
}
