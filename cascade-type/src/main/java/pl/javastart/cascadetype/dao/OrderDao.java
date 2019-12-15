package pl.javastart.cascadetype.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.cascadetype.model.Order;
import pl.javastart.cascadetype.model.Product;


@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
}
