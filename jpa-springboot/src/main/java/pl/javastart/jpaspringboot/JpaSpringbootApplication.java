package pl.javastart.jpaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.javastart.jpaspringboot.dao.BookDao;
import pl.javastart.jpaspringboot.model.Book;

@SpringBootApplication
public class JpaSpringbootApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(JpaSpringbootApplication.class, args);
        BookDao bookDao = ctx.getBean(BookDao.class);
        //Book book = new Book("Pawel", "Tomasz");
        //bookDao.save(book);
        Thread.sleep(5000);
       // System.out.println(bookDao.get(1));

    }

}
