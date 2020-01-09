package co.test;

import co.test.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.ConnectException;
import java.sql.*;
@Slf4j
public class FastCampus
{
    public static void main(String args[]) throws ClassNotFoundException
    {
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        MyService myservice = context.getBean(MyService.class);
        myservice.check();
        context.close();

//        context.register(AppDefaultConfig.class, AppDevConfig.class, AppConfig.class);
//        context.refresh();

//        Dao dao = context.getBean("dao", Dao.class);
//        Dao2 dao2 = context.getBean("dao2", Dao2.class);
//        dao2.run();
//        A a1 = context.getBean("A", A.class);
//        A a2 = context.getBean("A", A.class);

//        log.info("result : " + (a1 == a2));
//        ConnectionFactory factory = context.getBean(ConnectionFactory.class);
//        Connection con = factory.getConnection();
//        log.info("factory : " + (con != null));
//        Lifecycle li = context.getBean(Lifecycle.class);
//        log.info("" + li.isRunning());
//        context.close();
//        log.info("" + li.isRunning());
//        Dao a = context.getBean(Dao.class);
//        a.run();
    }
}
