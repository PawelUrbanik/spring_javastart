package pl.javastart.springjpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class JPAConfiguration {

    @Bean
    public LocalEntityManagerFactoryBean createEMF()
    {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("spring-jpa-pu");
        return factoryBean;
    }
}
