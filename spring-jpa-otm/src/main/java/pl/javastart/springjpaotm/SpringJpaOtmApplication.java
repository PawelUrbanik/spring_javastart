package pl.javastart.springjpaotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springjpaotm.dao.ClientDao;
import pl.javastart.springjpaotm.dao.OrderDao;
import pl.javastart.springjpaotm.dao.ProductDao;
import pl.javastart.springjpaotm.model.Client;
import pl.javastart.springjpaotm.model.Order;
import pl.javastart.springjpaotm.model.Product;

import java.util.HashSet;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
      ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

      Client client = new Client("pawel", "urb");
      ClientDao clientDao = ctx.getBean(ClientDao.class);
      clientDao.save(client);
      System.out.println("****************" +client);

        Order order = new Order();
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
      System.out.println("***************" + order.getId());
        orderDao.save(order);
      //System.out.println(orderDao.get(1L));

        Product product = new Product("mleko", 10.1);
        Product product2 = new Product("chleb", 2.5);
        ProductDao productDao = ctx.getBean(ProductDao.class);
        productDao.save(product);
        productDao.save(product2);

        orderDao.addProductsToOrder(order.getId(), product, product2);

        ctx.close();
    }

}
