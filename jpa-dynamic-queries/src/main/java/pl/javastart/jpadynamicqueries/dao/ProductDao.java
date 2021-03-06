package pl.javastart.jpadynamicqueries.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.jpadynamicqueries.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;
import java.util.StringJoiner;

@Repository
@Transactional
public class ProductDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Product product){
        entityManager.persist(product);
    }

    public Product get (Long key)
    {
        Product find = entityManager.find(Product.class, key);
        return find;
    }

    public List<Product> getAll()
    {
        TypedQuery<Product> getAllQuery = entityManager.createNamedQuery("Product.findAll", Product.class);
        List<Product> resutList = getAllQuery.getResultList();
        return resutList;
    }

    public Product getByName(String name)
    {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findByName", Product.class);
        query.setParameter("name", name);
        List<Product> list = query.getResultList();
        return list.get(0);
    }

    public int deleteAll()
    {
        Query deleteQuery = entityManager.createNamedQuery("Product.deleteAll");
        int deletedRows = deleteQuery.executeUpdate();
        return deletedRows;
    }

    public List<Product> customGet(String JpqlQuery)
    {
        TypedQuery<Product> customQuery = entityManager.createQuery(JpqlQuery, Product.class);
        return customQuery.getResultList();
    }

    public int deleteByProducer(String producer)
    {
        Query query = entityManager.createQuery("DELETE FROM Product p WHERE p.producer = :producer");
        query.setParameter("producer", producer);
        return query.executeUpdate();
    }


}
