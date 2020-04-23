package pl.javastart.springangularrouting;

import org.springframework.context.annotation.Configuration;
import pl.javastart.springangularrouting.model.Book;
import pl.javastart.springangularrouting.repository.BookRepo;

import java.util.Arrays;

@Configuration
public class Start {

    public Start(BookRepo bookRepo) {
        Book book = new Book();
        book.setTitle("Krzyżacy");
        book.setAuthor("Sienkiewicz");
        book.setIsbn("dcczza");
        bookRepo.save(book);


        Book book1 = new Book();
        book1.setTitle("Quo Vadis");
        book1.setAuthor("Sienkiewicz");
        book1.setIsbn("aslkjdak");
        bookRepo.save(book1);
    }
}
