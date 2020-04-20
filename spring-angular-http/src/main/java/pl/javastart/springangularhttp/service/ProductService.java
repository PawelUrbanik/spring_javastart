package pl.javastart.springangularhttp.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.springangularhttp.model.Product;
import pl.javastart.springangularhttp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product)
    {
        productRepository.save(product);
    }

    public List<Product> getAll() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }
}
