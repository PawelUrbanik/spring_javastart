package pl.javastart.springdataboot.repository;


import org.springframework.data.repository.CrudRepository;
import pl.javastart.springdataboot.model.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
