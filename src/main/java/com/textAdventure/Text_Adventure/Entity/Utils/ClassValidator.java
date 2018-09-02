package com.textAdventure.Text_Adventure.Entity.Utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.sql.Timestamp;
import java.util.Set;

public class ClassValidator {

    public static void validate(Object obj) {

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Object>> violations = validator.validate(obj);

        for(ConstraintViolation<Object> violation : violations) {
            System.out.println(
                    String.format("\n~~--=#=--~~\nViolation: \nTime: %s\nClass: %s\nVariable: %s\n~~--=#=--~~",
                            currentTime.toString(),
                    violation.getRootBeanClass().toString().substring(6),
                    violation.getPropertyPath())
            );
        }


    }

}
