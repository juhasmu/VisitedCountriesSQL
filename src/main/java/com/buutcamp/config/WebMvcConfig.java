package com.buutcamp.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@ComponentScan("com.buutcamp")
@EnableWebMvc
@EnableTransactionManagement
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver urlBasedViewResolver =
                new UrlBasedViewResolver();

        urlBasedViewResolver.setPrefix("/WEB-INF/views/");
        urlBasedViewResolver.setSuffix(".jsp");
        //urlBasedViewResolver.setPrefix(prefix);
        //urlBasedViewResolver.setSuffix(suffix);

        urlBasedViewResolver.setViewClass(JstlView.class);


        return urlBasedViewResolver;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory()throws SQLException{
        //Iniatialize sessionFactoryBean
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        //set sessionFactory data source
        sessionFactory.setDataSource(myDataSource());

        //tell hibernate proterities
        sessionFactory.setPackagesToScan("com.buutcamp.entity");
        //return sessionFactory
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;

    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;

    }
    DataSource myDataSource() throws SQLException{
        //Create
        DataSource dataSource = new BasicDataSource();//MysqlDataSource();

        //set connection info
        ((BasicDataSource) dataSource).setUrl("jdbc:mysql://localhost:3306/hibernate_simple_demo?serverTimezone=UTC&allowPublicKeyRetrieval=true");
        ((BasicDataSource) dataSource).setUsername("hibuser");
        ((BasicDataSource) dataSource).setPassword("salasana");
        ((BasicDataSource) dataSource).setDriverClassName("com.mysql.cj.jdbc.Driver");

        //((MysqlDataSource) dataSource).setDatabaseName("hibernate_simple_demo");
        //((MysqlDataSource) dataSource).setUser("hibuser");
        //((MysqlDataSource) dataSource).setPassword("salasana");

        return dataSource;
    }
    Properties hibernateProperties(){
        return new Properties(){
            {
            setProperty("hibernate.hbm2ddl.auto","update");
            setProperty("hibernate.show.sql","true");
            setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
            }
        };
    }
}
