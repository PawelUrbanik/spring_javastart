package pl.javastart.jpaspringboot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.jpaspringboot.model.Book;

import javax.persistence.*;

@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceContext
    EntityManager entityManager;

    public BookDaoImpl() {
    }

    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public void update(Book book) {
    entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Book bookDB = entityManager.find(Book.class, id);
        if (bookDB != null) entityManager.remove(bookDB);
        System.out.println("Book for id value " + bookDB.getId() + " was deleted");
    }

}
