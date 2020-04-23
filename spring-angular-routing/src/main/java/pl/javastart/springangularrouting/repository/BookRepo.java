package pl.javastart.springangularrouting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.springangularrouting.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
