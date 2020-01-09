package co.test;

import co.test.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@Profile("default | dev")
public class AppConfig {


    @Bean
    public B b()
    {
        System.out.println("OR");
        return new B();
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean()
    {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MyService myService()
    {
        return new MyService();
    }

}
