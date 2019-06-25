package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.javastart.beans.NamesRepository;

import java.util.List;

@Configuration
@ComponentScan
public class SpringDiApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApp.class);

        NamesRepository namesRepository = ctx.getBean(NamesRepository.class);
        List<String> allNames = namesRepository.getAll();
        allNames.forEach(System.out::println);

        ctx.close();
    }

}
