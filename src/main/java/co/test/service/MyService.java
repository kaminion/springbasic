package co.test.service;

import co.test.validate.PersonForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Locale;
import java.util.Set;

@Service
@Slf4j
public class MyService {
    // 자바 X꺼임 SPRING아니라
    @Autowired
    private Validator validator;

    public void check() {
        PersonForm personForm = new PersonForm("fats", 121);
        Set<ConstraintViolation<PersonForm>> result = validator.validate(personForm);

        if(result.isEmpty()) {
            log.info("validate 성공");
        }else {
           result.forEach( x-> {
               log.error(x.getMessage());
           });

        }

    }

}
