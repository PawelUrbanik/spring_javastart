package pl.javastart.springjpaotm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springjpaotm.dao.ClientDao;
import pl.javastart.springjpaotm.dao.OrderDao;
import pl.javastart.springjpaotm.model.Client;
import pl.javastart.springjpaotm.model.Order;

@SpringBootApplication
public class SpringJpaOtmApplication {

    public static void main(String[] args) {
      ConfigurableApplicationContext ctx = SpringApplication.run(SpringJpaOtmApplication.class, args);

        Client client = new Client("pawel", "urb");
        ClientDao clientDao = ctx.getBean(ClientDao.class);
        clientDao.save(client);
        System.out.println(client);

        Order order = new Order("mleko");
        order.setClient(client);
        OrderDao orderDao = ctx.getBean(OrderDao.class);
        orderDao.save(order);

        Order getOrd = orderDao.get(2L);
        System.out.println(getOrd);

        Client getClient = clientDao.get(1L);
        System.out.println(getClient);

        ctx.close();
    }

}
