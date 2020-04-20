package pl.javastart.springangularhttp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springangularhttp.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
