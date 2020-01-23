package pl.javastart.springvalidatorgroups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import pl.javastart.springvalidatorgroups.model.Project;
import pl.javastart.springvalidatorgroups.service.ProjectService;

import javax.validation.Validator;
import java.sql.Date;
import java.time.Instant;

@SpringBootApplication
public class SpringValidatorGroupsApplication {

    public static void main(String[] args) {
       ConfigurableApplicationContext ctx = SpringApplication.run(SpringValidatorGroupsApplication.class, args);

        ProjectService projectService = ctx.getBean(ProjectService.class);

        Project project = new Project();
        project.setTitle("Tittle");
        project.setDate(Date.from(Instant.now()));

        boolean validDraft = projectService.validateDraft(project);
        System.out.println("Draft is valid ?: " + validDraft);



        project.setDescription("Description of Full project");
      //  project.setOwner("Joerge bush");

        boolean validFull = projectService.validateFull(project);
        System.out.println("Is full valid? : " + validFull);


        ctx.close();
    }



    public Validator validator(){
        return new LocalValidatorFactoryBean();
    }
}
