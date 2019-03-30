package pl.javastart.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.javastart.beans.MessagePrinter;

public class SpringDiApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        MessagePrinter messagePrinter = ctx.getBean(MessagePrinter.class);
        messagePrinter.printMessage();
        ctx.close();
    }
}
