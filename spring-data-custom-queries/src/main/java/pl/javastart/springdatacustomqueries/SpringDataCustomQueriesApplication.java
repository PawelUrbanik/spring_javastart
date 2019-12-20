package pl.javastart.springdatacustomqueries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springdatacustomqueries.model.Employee;
import pl.javastart.springdatacustomqueries.repository.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataCustomQueriesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringDataCustomQueriesApplication.class, args);

        EmployeeRepository emplRepo = ctx.getBean(EmployeeRepository.class);

        Stream.of(new Employee("Jan", "Kowalski", 2600.0),
                new Employee("Paweł", "Urban", 2200.0),
                new Employee("Łukasz", "Nozly", 3200.0),
                new Employee("Szymon", "Bach", 4200.0))
                .forEach(emplRepo::save);

        emplRepo.findAll().forEach(System.out::println);
        emplRepo.findByNameAndSalary("Jan", 2200).forEach(System.out::println);
        emplRepo.namesForSalaryAsc(2201).forEach(System.out::println);

        ctx.close();
    }

}
