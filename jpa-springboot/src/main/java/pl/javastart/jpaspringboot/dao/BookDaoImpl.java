package pl.javastart.jpaspringboot.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.jpaspringboot.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

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
