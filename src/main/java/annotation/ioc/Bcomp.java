package annotation.ioc;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

@Slf4j
public class Bcomp {

    @Autowired
    private Acomp a;

    public Bcomp(Acomp a)
    {
        this.a = a;
    }

    @PostConstruct
    void init()
    {
        log.info("init" + a);
    }
    @PreDestroy
    void destory()
    {
        log.error("destory");
    }

}
