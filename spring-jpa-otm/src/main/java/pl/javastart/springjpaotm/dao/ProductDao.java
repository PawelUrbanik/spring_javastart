package pl.javastart.springjpaotm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.springjpaotm.model.Product;

@Transactional
@Repository
public class ProductDao extends GenericDao<Product, Long> {

}
