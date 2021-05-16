package test;

import com.zsy.ssm.entity.User;

import org.hibernate.validator.HibernateValidator;

import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;

/**
 * @Title test
 * @date 2021/5/15
 * @autor Zsy
 */

public class TestValid {

    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        ValidatorFactory factory = Validation
                .buildDefaultValidatorFactory();
        Validator validator = factory
                .getValidator();
        User user = new User();
        user.password = "1";
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);
        for (ConstraintViolation<User> constraintViolation : constraintViolationSet) {
            System.out.println(constraintViolation.getMessage());
        }
    }


    public static void test2() {
        ValidatorFactory validatorFactory = Validation
                .byProvider(HibernateValidator.class)
                .configure()
                .addProperty("{name.error}", "true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        User user = new User();
        user.username = "测试名称长度测试名称长度测试名称长度";
        Set<ConstraintViolation<User>> constraintViolationSet = validator.validate(user);
        for (ConstraintViolation<User> constraintViolation : constraintViolationSet) {
            System.out.println(constraintViolation.getMessage());
        }
    }


}
