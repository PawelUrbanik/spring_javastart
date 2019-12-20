package pl.javastart.springdatacustomqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.javastart.springdatacustomqueries.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.findByNameAndSalary")
    List<Employee> findByNameAndSalary(@Param("name") String name, @Param("salary") double salary);

    @Query("SELECT e.lastName FROM Employee e WHERE e.salary >= :salary ORDER BY e.salary ASC")
    List<String> namesForSalaryAsc(@Param("salary") double salary);
}
