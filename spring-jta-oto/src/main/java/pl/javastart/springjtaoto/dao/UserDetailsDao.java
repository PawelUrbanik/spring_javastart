package pl.javastart.springjtaoto.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.springjtaoto.model.User;
import pl.javastart.springjtaoto.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDetailsDao {

    @PersistenceContext
    EntityManager entityManager ;

    public UserDetails get(Long id){
        UserDetails details = entityManager.find(UserDetails.class, id);
        return details;
    }
}
