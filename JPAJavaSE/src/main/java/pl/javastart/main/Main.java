package pl.javastart.main;

import pl.javastart.dao.BookDao;
import pl.javastart.dao.BookDaoImpl;
import pl.javastart.model.Book;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Pustynia", "Tomasz");
        BookDao dao = new BookDaoImpl();
        dao.save(book);
        System.out.println("Book saved");
        System.out.println(dao.get(1));
        dao.cleanUp();
    }
}
