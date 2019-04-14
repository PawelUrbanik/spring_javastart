package pl.javastart.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import pl.javastart.beans.MessagePrinter;
import pl.javastart.beans.MessageProducer;

@Configuration
@ComponentScan("pl.javastart.beans")
public class SpringDiApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApp.class);

        MessagePrinter printer1 = ctx.getBean(MessagePrinter.class);
        printer1.printMessage();
        MessagePrinter printer2 = ctx.getBean(MessagePrinter.class);
        printer2.printMessage();
        ctx.close();
    }
}
