package pl.javastart.dao;

import pl.javastart.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BookDaoImpl implements BookDao{

    EntityManagerFactory factory;
    EntityManager manager;

    public BookDaoImpl() {
        this.factory = Persistence.createEntityManagerFactory("myPersistanceUnit");
        this.manager = factory.createEntityManager();
    }

    public void save(Book book) {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(book);
        transaction.commit();
    }

    public Book get(int id) {
        Book book = manager.find(Book.class, id);
        return book;
    }

    public void cleanUp() {
        manager.close();
        factory.close();
    }
}
