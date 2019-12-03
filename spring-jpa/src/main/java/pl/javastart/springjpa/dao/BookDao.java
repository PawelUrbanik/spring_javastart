package pl.javastart.springjpa.dao;

import pl.javastart.springjpa.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(int id);
}
