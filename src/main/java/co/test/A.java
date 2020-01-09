package co.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class A
{
    //@Resource(name="appBeanB1")
    private B b;
    @Value("${catalog.name}") String catalogName;
    @Value("#{systemProperties['hello']}") String properties;

    @PostConstruct
    public void init()
    {
        log.info("" + b);
    }
    @PreDestroy
    public void destroy()
    {
        log.error("close");
    }

}


@Slf4j
class BringSpringContainer {

    @Autowired
    private ApplicationContext applicationContext;

    public void init() {
        log.error(">>" + applicationContext);
    }
}
