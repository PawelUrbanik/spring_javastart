package pl.javastart.springangularhttp;


import org.springframework.context.annotation.Configuration;
import pl.javastart.springangularhttp.model.Product;
import pl.javastart.springangularhttp.service.ProductService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Start {


    public Start(ProductService productService) {
        Product product = new Product();
        product.setName("Sałatta");
        product.setProducer("Rolnik");
        product.setKcal(50);
        productService.addProduct(product);


        Product product2 = new Product();
        product2.setName("Pomidor");
        product2.setProducer("Rolnik");
        product2.setKcal(60);
        productService.addProduct(product2);
    }


}
