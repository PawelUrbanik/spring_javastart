package pl.javastart.jpaspringboot.dao;

import pl.javastart.jpaspringboot.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(Long id);
    public void update(Book book);
    public void delete(Long id);
}
