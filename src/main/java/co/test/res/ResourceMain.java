package co.test.res;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ResourceMain {
    public static void main(String[] args) throws IOException {

        // ClassPath
//        ClassPathResource cpr = new ClassPathResource("dao.xml");
//        System.out.println(cpr.exists());
//        byte[] bytes = Files.readAllBytes(Paths.get(cpr.getFile().getPath()));
//        String s = new String(bytes);
//        System.out.println(s);

        // URLRESOURCE
//        UrlResource ur = new UrlResource("file:C:\\Users\\Ahnjoongwon\\Desktop\\SPRING BASIC\\src\\main\\resources\\dao.xml");
//        System.out.println(ur.exists());

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
//        Resource res = context.getResource("https://cdn.www.fastcampus.co.kr/wp-content/uploads/2017/11/fastcampus_logo_positive-1.png");
//
//        String daoStr = new String(res.getURL().getPath());
//        System.out.println(daoStr);
//        context.close();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ResourceExample.class);
        context.refresh();
        ResourceExample re = context.getBean(ResourceExample.class);
        re.print();
        context.close();

    }
}
