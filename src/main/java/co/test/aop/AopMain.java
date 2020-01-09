package co.test.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        // 사용위해서 aspectjrt(RUNTIME) 의존성 추가해야함 weaver도 추가
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Service aopBean = context.getBean(Service.class);
        aopBean.log();
        context.close();
    }
}
