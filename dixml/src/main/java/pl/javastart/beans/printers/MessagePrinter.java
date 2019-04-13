package pl.javastart.beans.printers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.javastart.beans.decorators.MessageDecorator;
import pl.javastart.beans.producers.MessageProducer;

@Component
public class MessagePrinter {

    private MessageProducer messageProducer;
    private MessageDecorator messageDecorator;

    public MessagePrinter() {
    }
    @Autowired
    public MessagePrinter(@Qualifier("fileMessageProducer") MessageProducer messageProducer)
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
    public void setMessageDecorator(MessageDecorator messageDecorator) {
        this.messageDecorator = messageDecorator;
    }
}
