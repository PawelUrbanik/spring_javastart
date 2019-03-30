package pl.javastart.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.javastart.beans.MessagePrinter;

public class SpringDiApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
        ctx.close();
    }
}
