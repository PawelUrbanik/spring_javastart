package pl.javastart.cascadetype.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.cascadetype.model.Product;


@Transactional
@Repository
public class ProductDao extends GenericDao<Product, Long> {

}
