package pl.javastart.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.javastart.beans.printers.MessagePrinter;

@Configuration
@ComponentScan(basePackages = "pl.javastart")
public class SpringDiApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApp.class);
        MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
        ctx.close();
    }
}
