package ru.gruzdov.mvc.config;


import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "ru.gruzdov.mvc")
@EnableTransactionManagement
/*позволяет использовать TransactionManager для управления транзакциями.
Hibernate работает с БД с помощью транзакций, они нужны чтобы какой-то набор операций выполнялся как единое целое,
 т.е. если в методе возникнут проблемы с какой-то одной операцией, тогда не выполнятся и все остальные,
 чтобы не было как в классическом примере с переводом денег, когда операция снятия денег с одного счета свершилась,
  а операция записи на другой не сработала, в итоге деньги исчезли.*/
@PropertySource(value="classpath:db.property") //подключение файла свойств

public class HibernateConfig {
    @Autowired
    private Environment environment;//чтобы получить свойства из property файла.


    private Properties hibernateProperties() { //чтобы представить свойства Hibernate в виде объекта Properties
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
    @Bean
    public DataSource dataSource() { //используется для создания соединения с БД
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("db.driverClassName"));
        dataSource.setUsername(environment.getRequiredProperty("db.username"));
        dataSource.setPassword(environment.getRequiredProperty("db.password"));
        dataSource.setUrl(environment.getRequiredProperty("db.url"));
        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() { //для создания сессий, с помощью которых осуществляются операции с объектами-сущностями
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.gruzdov.mvc.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    @Bean
    public HibernateTransactionManager transactionManager() { //настройки менеджера транзакций.
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
