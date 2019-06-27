package pl.javastart.spring5di;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.spring5di.beans.NamesRepository;

import java.util.List;

@SpringBootApplication
public class Spring5DiApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(Spring5DiApplication.class, args);
        NamesRepository namesRepository = ctx.getBean(NamesRepository.class);
        List<String> allNames = namesRepository.getAll();
        allNames.forEach(System.out::println);

        ctx.close();
    }
}
