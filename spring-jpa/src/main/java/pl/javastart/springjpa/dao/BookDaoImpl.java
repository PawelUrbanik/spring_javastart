package pl.javastart.springjpa.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.springjpa.model.Book;

import javax.persistence.*;

@Repository
public class BookDaoImpl implements BookDao{

    @PersistenceUnit
    EntityManagerFactory factory;

    public BookDaoImpl() {
    }

    public void save(Book book) {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(book);
        transaction.commit();
        manager.close();
    }

    public Book get(int id) {
        EntityManager manager = factory.createEntityManager();
        Book book = manager.find(Book.class, id);
        manager.close();
        return book;
    }

}
