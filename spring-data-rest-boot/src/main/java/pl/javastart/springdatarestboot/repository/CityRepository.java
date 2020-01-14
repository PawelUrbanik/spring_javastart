package pl.javastart.springdatarestboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.javastart.springdatarestboot.model.City;

@RepositoryRestResource
public interface CityRepository  extends JpaRepository<City, Long> {
}
