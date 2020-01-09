package co.test.validate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Person a = new Person("name", 200);
        PersonValidator validator = new PersonValidator();
        if(validator.supports(a.getClass()))
        {
            BindException error = new BindException(a, "person");
            validator.validate(a, error);

            System.out.println(error.hasErrors());
            log.error("" + error.getAllErrors());

        }else{
            log.error("invalid class");
        }


    }
}
