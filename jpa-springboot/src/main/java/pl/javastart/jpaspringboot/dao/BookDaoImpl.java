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

    public Book get(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }

}
