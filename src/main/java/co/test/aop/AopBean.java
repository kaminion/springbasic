package co.test.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

@Slf4j
public class AopBean {

    public void beforelog()
    {
        log.error("before log");
    }

    public void afterlog()
    {
        log.error("after log");
    }

    public void afterReturnLog()
    {
        log.error("after Returning log");
    }

    public void afterThrowingLog()
    {
        log.error("after Throwing log");
    }

    public void aroundLog(ProceedingJoinPoint pjp)
    {
        log.error("before log");
        try{
            pjp.proceed();
            log.error("returning aop log");
        }catch(Throwable throwable)
        {
            log.error("throwing aop log");
        }

        log.error("after Log");
    }
}
