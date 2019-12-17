package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.javastart.model.Car;
import pl.javastart.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"pl.javastart.*"})
public class SpringDataApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(SpringDataApplication.class);
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));

        CarRepository carRepo = aca.getBean(CarRepository.class);
        cars.forEach(carRepo::save);

        Car firstCar = carRepo.findById(1L).get();
        carRepo.delete(firstCar);

        carRepo.findAll().forEach(System.out::println);

        aca.close();
    }

}
