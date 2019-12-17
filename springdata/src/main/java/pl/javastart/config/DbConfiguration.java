package pl.javastart.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.javastart.repository.CarRepository;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = CarRepository.class)
public class DbConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter adapter, DataSource ds)
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("spring-jpa-pu");
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("spring.jpa.hibernate.ddl-auto", "create");
        entityManagerFactoryBean.setJpaPropertyMap(properties);
        entityManagerFactoryBean.setDataSource(ds);
        entityManagerFactoryBean.setJpaVendorAdapter(adapter);
        entityManagerFactoryBean.setPackagesToScan("pl.javastart.model");
        return entityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter createVendorAdapter (){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setGenerateDdl(true);
        adapter.setShowSql(true);
        return adapter;
    }

    @Bean
    public DataSource createDS(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Europe/Warsaw");
        ds.setUsername("root");
        ds.setPassword("");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setInitialSize(5);
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager (EntityManagerFactory entityManagerFactory)
    {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
        return jpaTransactionManager;
    }


}
