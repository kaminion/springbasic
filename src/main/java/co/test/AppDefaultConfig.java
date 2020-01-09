package co.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;

@Configuration
@PropertySource("classpath:application.properties")
//@ComponentScan(basePackages = "co.test")
@Profile("default")
public class AppDefaultConfig {

//    @Bean
//    @Qualifier("b1")
//    public B appBeanB1()
//    {
//       return new B();
//    }
//
//    @Bean
//    @Qualifier("b2")
//    public B appBeanB2()
//    {
//        return new B();
//    }
//

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ConnectionFactory connectionFactory()
    {
        System.out.println("default");
        return new ConnectionFactory("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&amp", "root", "1234");
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory)
    {
        return connectionFactory.getConnection();
    }

    @Bean
    public Dao dao(Connection connection)
    {
        return new Dao(connection);
    }
}
