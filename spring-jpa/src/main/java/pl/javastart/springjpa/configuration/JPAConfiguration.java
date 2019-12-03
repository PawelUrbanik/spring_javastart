package pl.javastart.springjpa.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JPAConfiguration {

    @Bean
    public LocalContainerEntityManagerFactoryBean createEMF(JpaVendorAdapter adapter, DataSource ds){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();

        //properties.put("hibernate.hbm2ddl.auto","create");
        emf.setPersistenceUnitName("spring-jpa-pu");
        emf.setDataSource(ds);
        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("pl.javastart.springjpa");
        return emf;
    }

   @Bean
    public JpaVendorAdapter createVendorAdapter(){
       HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
       adapter.setDatabase(Database.MYSQL);
       adapter.setShowSql(true);
       return adapter;
   }

   @Bean
    public DataSource createDS(){
       BasicDataSource ds = new BasicDataSource();
       ds.setUrl("jdbc:mysql://localhost:3306/library_jse?useSSL=false&serverTimezone=Europe/Warsaw");
       ds.setUsername("root");
       ds.setPassword("");
       ds.setDriverClassName("com.mysql.jdbc.Driver");
       ds.setInitialSize(5);
       return ds;
   }
}
