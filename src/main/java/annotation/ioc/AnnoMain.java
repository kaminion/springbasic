package annotation.ioc;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Slf4j
public class AnnoMain {
    public static void main(String argv[])
    {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext();
        container.register(AppConfig.class);
        container.refresh();

        Bcomp b = container.getBean(Bcomp.class);
        log.info("loginstance : " + b);
        container.close();
    }
}
