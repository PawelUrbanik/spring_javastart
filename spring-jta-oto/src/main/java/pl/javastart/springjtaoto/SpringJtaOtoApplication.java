package pl.javastart.springjtaoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pl.javastart.springjtaoto.dao.UserDao;
import pl.javastart.springjtaoto.dao.UserDaoImpl;
import pl.javastart.springjtaoto.dao.UserDetailsDao;
import pl.javastart.springjtaoto.model.User;
import pl.javastart.springjtaoto.model.UserDetails;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringJtaOtoApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringJtaOtoApplication.class, args);
        UserDao userDao = context.getBean(UserDaoImpl.class);
        UserDetailsDao userDetailsDao = context.getBean(UserDetailsDao.class);

        User user = new User("username","passwd", "email");
        UserDetails details = new UserDetails("name","lastname", "adress");
        user.setDetails(details);
        System.out.println(user);

        userDao.save(user);
        Thread.sleep(2000);
        userDao.get(1L);

        User fromDb = (User) userDao.get(2L);
        fromDb.setPasswd("password");

        userDao.update(fromDb);

        System.out.println(userDao.get(2L));

        //userDao.delete(2L);

        System.out.println(userDetailsDao.get(1L));

        context.close();
    }

}
