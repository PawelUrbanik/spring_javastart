package pl.javastart.springjtaoto.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.javastart.springjtaoto.model.User;
import pl.javastart.springjtaoto.model.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserDaoImpl implements UserDao<Long, User> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User obj) {
        UserDetails details = obj.getDetails();
        if (details != null && details.getId()== null)
        {
            entityManager.persist(details);
        }
        entityManager.persist(obj);
    }

    @Override
    public User get(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User obj) {
        UserDetails details = obj.getDetails();
        if (details != null)
        {
           entityManager.merge(details);
            obj.setDetails(details);
        }
        entityManager.merge(obj);
    }

    @Override
    public void delete(Long id) {
        User user = entityManager.find(User.class, id);
        UserDetails details = user.getDetails();
        entityManager.remove(details);
        entityManager.remove(user);
    }
}
