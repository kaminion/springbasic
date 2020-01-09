package co.test.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {

        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.addAdvice(new RetryAdvice());

        Pojo pojo = (Pojo)factory.getProxy();
        pojo.bar();
        pojo.foo();

    }
}

class RetryAdvice implements MethodInterceptor
{
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before");
        Object proceed = methodInvocation.proceed();
        System.out.println("after");
        return proceed;

    }
}

interface Pojo
{
    void foo();
    void bar();

}

class SimplePojo implements Pojo
{
    public void foo()
    {
        // this next method direct call
       System.out.println("run");
       //this.bar();
    }

    public void bar()
    {
        //some logic...
        System.out.println("proxy");
    }

}