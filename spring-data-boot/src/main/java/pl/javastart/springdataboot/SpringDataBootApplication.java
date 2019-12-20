package pl.javastart.springdataboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springdataboot.model.Car;
import pl.javastart.springdataboot.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataBootApplication {

    public static void main(String[] args) {
      ConfigurableApplicationContext ctx =  SpringApplication.run(SpringDataBootApplication.class, args);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opelek", 29500.0));
        cars.add(new Car("A4", "Audi", 49000.0));
        cars.add(new Car("A5", "Audi", 67000.0));
        cars.add(new Car("Auris", "Toyota", 35000.0));
        cars.add(new Car("Insignia", "Opel", 29500.0));
        cars.add(new Car("A8", "Audi", 28000.0));
        cars.add(new Car("Corolla", "Toyota", 31000.0));
        cars.add(new Car("Vectra", "Opel", 29500.0));
        cars.add(new Car("Astra", "Opel", 29500.0));

        CarRepository carRepository = ctx.getBean(CarRepository.class);
        cars.forEach(carRepository::save);

        //findAllByBrand
        List<Car> toyotaCars = carRepository.findAllByBrand("Toyota");
        toyotaCars.forEach(System.out::println);

        //findByBrand
        Car opel = carRepository.findCarByBrand("Opelek");
        System.out.println("Opelek: "+ opel);

        //Obiekt findCarByPrice
        Car a8 = carRepository.findCarByPrice(28000.0);
        System.out.println("A8 cena: "+ a8);

        //findFirst3ByBrand
        List<Car> first3 = carRepository.findFirst3ByBrand("Opel");
        first3.forEach(System.out::println);

        //Marka i cena
        List<Car> brandAndPrice = carRepository.findAllByBrandAndPrice("Audi", 28000.0);
        brandAndPrice.forEach(System.out::println);

        List<Car> markOrMark = carRepository.findAllByBrandOrBrand("Audi", "Toyota");
        markOrMark.forEach(System.out::println);

        //Marka określana przez wzorzec
        List<Car> markLike = carRepository.findAllByBrandLike("A%");
        markLike.forEach(System.out::println);


        List<Car> markEnding = carRepository.findAllByNameEndingWith("a");
        markEnding.forEach(System.out::println);


        List<Car> priceLess = carRepository.findAllByPriceLessThan(29500.0);
        priceLess.forEach(System.out::println);

        //Cena pomiędzy
      List<Car> priceBetween = carRepository.findAllByPriceBetween(29500.0, 49000.0 );
      priceBetween.forEach(System.out::println);

      //Po nazwie posortowane wg ceny
      List<Car> brandOrder = carRepository.findAllByBrandOrderByPriceAsc("Toyota");
      brandOrder.forEach(System.out::println);

      List<Car> brandNN = carRepository.findAllByBrandNotNull();
      brandNN.forEach(System.out::println);

      List<String> carNames = Stream.of("Insygnia", "Corolla").collect(Collectors.toList());
      carRepository.findAllByNameIn(carNames).forEach(System.out::println);
      ctx.close();
    }

}
