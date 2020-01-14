package pl.javasatart.springdatarestconf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.javasatart.springdatarestconf.model.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
