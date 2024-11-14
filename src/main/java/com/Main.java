package com;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        PathSegment pathSegment = new PathSegment("A123!", "A", 0);

        Set<ConstraintViolation<PathSegment>> violations = validator.validate(pathSegment);

        if (violations.isEmpty()) {
            System.out.println("All validations passed successfully!");
        } else {
            for (ConstraintViolation<PathSegment> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
    }
}
