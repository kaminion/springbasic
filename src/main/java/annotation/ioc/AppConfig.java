package annotation.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackageClasses = annotation.ioc.AppConfig.class)
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Bcomp b(Acomp a)
    {
        return new Bcomp(a);
    }

    @Bean
    public Acomp A()
    {
        return new Acomp();
    }

}
