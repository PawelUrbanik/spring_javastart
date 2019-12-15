package pl.javastart.cascadetype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.cascadetype.dao.ClientDao;
import pl.javastart.cascadetype.model.Client;
import pl.javastart.cascadetype.model.Order;
import pl.javastart.cascadetype.model.Product;

@SpringBootApplication
public class CascadeTypeApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(CascadeTypeApplication.class, args);
        Client client = new Client("Paweł", "Urban");
        Order order = new Order();
        Product product1 = new Product("Mleko", 2.50);
        Product product2 = new Product("Platki", 4.00);
        order.getProducts().add(product1);
        order.getProducts().add(product2);
        Thread.sleep(1000);
        order.setClient(client);
        client.getOrders().add(order);


        ClientDao clientDao = context.getBean(ClientDao.class);System.out.println(client);
        clientDao.save(client);

        clientDao.removeAllOrders(client);
        context.close();

    }

}
