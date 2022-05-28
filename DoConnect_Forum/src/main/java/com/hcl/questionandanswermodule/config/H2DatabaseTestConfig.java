//package com.hcl.questionandanswermodule.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@PropertySource("classpath:application-test.properties")
//@EnableTransactionManagement
//public class H2DatabaseTestConfig {
//    private Environment env;
//
//    @Autowired
//    public H2DatabaseTestConfig(Environment env) {
//        this.env = env;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1", "sa", "sa");
//        new ResourceDatabasePopulator(new ClassPathResource("/schema1.sql")).execute(dataSource);
//
//        return dataSource;
//    }
//}
