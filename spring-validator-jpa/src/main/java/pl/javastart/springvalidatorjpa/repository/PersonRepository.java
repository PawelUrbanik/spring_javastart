package pl.javastart.springvalidatorjpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.springvalidatorjpa.model.Person;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Repository
public class PersonRepository {

    private EntityManager entityManager;

    @Autowired
    public PersonRepository (EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Transactional
    public void add(Person person)
    {
        entityManager.persist(person);
    }
}

