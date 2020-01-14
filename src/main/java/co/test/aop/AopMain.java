package co.test.aop;

import co.test.Dao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class AopMain {
    public static void main(String[] args) throws SQLException {
        // 사용위해서 aspectjrt(RUNTIME) 의존성 추가해야함 weaver도 추가
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        Dao aopBean = context.getBean(Dao.class);
        aopBean.insert();
        aopBean.print();
        context.close();
    }
}
