package co.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.annotation.Resource;
import java.sql.Connection;

@Configuration
@PropertySource("classpath:application-dev.properties")
//@ComponentScan(basePackages = "co.test")
@Profile("dev")
public class AppDevConfig {

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
    public ConnectionFactory connectionFactory(@Value("${jdbc.driver-Class}") String driverClass,
                                               @Value("${jdbc.url}") String url,
                                               @Value("${jdbc.username}") String username,
                                               @Value("${jdbc.password}") String password)
    {
        System.out.println("dev");
        return new ConnectionFactory(driverClass, url, username, password);
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
