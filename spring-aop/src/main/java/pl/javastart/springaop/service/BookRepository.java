package pl.javastart.springaop.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pl.javastart.springaop.model.Book;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class BookRepository implements GenericRepository<String, Book> {

    private List<Book> books;

    public BookRepository() {
        books = new LinkedList<>();
    }

    @Override
    public Book get(String isbn) {
        /*Instant start = Instant.now();*/
        if (isbn==null || (isbn.length())!= 13) throw new IllegalArgumentException("Book isbn is valid");
        Book find = books.stream()
                .filter(b->isbn.equals(b.getIsbn()))
                .findFirst()
                .get();
        randomPause(300);
       /* Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        System.out.println("Duration time: " + between.toMillis());*/
        return find;
    }

    @Override
    public void add(Book book) {
        if ( book == null || book.getIsbn()==null||book.getTitle()==null||book.getAuthor()==null)
            throw new IllegalArgumentException("Book cannot have null fields");
        randomPause(1000);
        books.add(book);
    }

    private void randomPause(int maxTime)
    {
        try {
            Thread.sleep(new Random().nextInt(maxTime));
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
