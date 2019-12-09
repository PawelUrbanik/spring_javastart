package pl.javastart.springjpaotm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.springjpaotm.model.Order;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {

}
