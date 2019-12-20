package pl.javastart.springdataboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.springdataboot.model.Car;

import java.util.Collection;
import java.util.List;


public interface CarRepository extends JpaRepository<Car, Long> {


    List<Car> findAllByBrand(String brand);

    Car findCarByBrand(String brand);

    Car findCarByPrice(double price);

    List<Car> findFirst3ByBrand(String brand);

    List<Car> findAllByBrandAndPrice(String brand, double price);

    List<Car> findAllByBrandOrBrand(String brand1, String brand2);

    List<Car> findAllByBrandLike(String pattern);

    List<Car> findAllByNameEndingWith(String name);

    List<Car> findAllByPriceLessThan(double price);

    List<Car> findAllByPriceBetween(double min, double max);

    List<Car> findAllByBrandOrderByPriceAsc(String brand);

    List<Car> findAllByBrandNotNull();

    List<Car> findAllByNameIn(Collection<String> names);
}
