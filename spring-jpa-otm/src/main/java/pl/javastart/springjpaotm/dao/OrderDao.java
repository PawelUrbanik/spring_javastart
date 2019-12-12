package pl.javastart.springjpaotm.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.springjpaotm.model.Order;
import pl.javastart.springjpaotm.model.Product;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {


    public void addProductsToOrder(Long orderId, Product... products){
        Order order = get(orderId);
        if (order!= null){
            for (Product product: products) {
                order.getProducts().add(product);
            }
        }
    }

    @Override
    public Order get(Long key) {
        Order order = super.get(key);
        order.getClient().getId();
        return order;
    }


}
