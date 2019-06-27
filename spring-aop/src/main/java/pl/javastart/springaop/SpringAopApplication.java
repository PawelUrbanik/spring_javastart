package pl.javastart.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.javastart.springaop.model.Book;
import pl.javastart.springaop.service.BookRepository;
import pl.javastart.springaop.service.GenericRepository;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringAopApplication.class, args);
        BookRepository repository = ctx.getBean(BookRepository.class);
        repository.add(new Book("1234567890123", "Pierwsza", "Pierwszy autor"));
        repository.add(new Book("2345678901234", "Druga", "Drugi autor"));
        repository.add(new Book("3456789012345", "Trzecia", "Trzeci autor"));
        Book book = repository.get("1234567890123");
        System.out.println(book);


        ctx.close();
    }

}
