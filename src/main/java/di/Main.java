package di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext ap = new ClassPathXmlApplicationContext("dao.xml");
        A a = ap.getBean("A", A.class);
        a.print();

    }
}
