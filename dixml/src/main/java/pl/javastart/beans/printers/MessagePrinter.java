package pl.javastart.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.javastart.beans.decorators.Decorator;
import pl.javastart.beans.decorators.MessageDecorator;
import pl.javastart.beans.producers.FileMessage;
import pl.javastart.beans.producers.MessageProducer;
import pl.javastart.beans.producers.Producer;

@Component
public class MessagePrinter {

    private MessageProducer messageProducer;
    private MessageDecorator messageDecorator;

    public MessagePrinter() {
    }

    @Autowired
    public MessagePrinter(@Producer(type = Producer.ProducerType.SIMPLE) MessageProducer messageProducer)
    {
        this.messageProducer = messageProducer;
    }

    public void printMessage(){
        String message = messageProducer.getMessage();
        message = messageDecorator != null?messageDecorator.decorate(message):message;
        System.out.println(message);
    }

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    public void setMessageProducer(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
    @Autowired(required = false)
    public void setMessageDecorator(@Decorator(type = Decorator.DecoratorType.UPPER) MessageDecorator messageDecorator) {
        this.messageDecorator = messageDecorator;
    }
}
