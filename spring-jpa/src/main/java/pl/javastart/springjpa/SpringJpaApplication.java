package pl.javastart.springjpa;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.javastart.springjpa.dao.BookDao;
import pl.javastart.springjpa.model.Book;

@Configuration
@ComponentScan
public class SpringJpaApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        Book book = new Book("Ania", "Tomasz");
        bookDao.save(book);
        System.out.println(bookDao.get(1));

    }

}
