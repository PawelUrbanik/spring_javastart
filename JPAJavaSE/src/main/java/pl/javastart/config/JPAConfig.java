package pl.javastart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JPAConfig {

    public LocalEntityManagerFactoryBean createEMF()
    {
        LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
        emf.setPersistenceUnitName("spring-jpa-pu");
        return emf;
    }
}
