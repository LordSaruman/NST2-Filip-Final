/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.spring.springdata.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author filip
 */
@Configuration
@ComponentScan(basePackages = "rs.fon.silab.spring.springdata")
//@ComponentScan(basePackages = {"rs.fon.silab.spring.springdata", "com.ff.jasper"})
@EnableTransactionManagement
public class MySpringDataPersistenceJPAConfig {

    public MySpringDataPersistenceJPAConfig() {
        System.out.println("Constructor: public MySpringDataPersistenceJPAConfig()");
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        System.out.println("@Bean: public LocalContainerEntityManagerFactoryBean entityManagerFactory()");
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("nst_master");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        System.out.println("@Bean: public PlatformTransactionManager transactionManager(EntityManagerFactory emf)");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        //properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }       
}
