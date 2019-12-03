package pl.javastart.jpaspringboot.dao;

import pl.javastart.jpaspringboot.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(int id);
}
