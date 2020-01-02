package pl.javastart.springmvcdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springmvcdata.model.TimeData;

@Repository
public interface TimeDataRepository extends JpaRepository<TimeData, Long> {
}
