package pl.javastart.dao;

import pl.javastart.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(int id);
    public void cleanUp();
}
