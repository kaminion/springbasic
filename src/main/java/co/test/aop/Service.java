package co.test.aop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service {
    public void log()
    {
        log.error("AOP LOG");
    }
}
