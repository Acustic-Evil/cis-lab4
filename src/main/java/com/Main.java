package com;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PathSegment pathSegment = new PathSegment("A123!", "A", 0);
        PathSegment pathSegment2 = new PathSegment("A123", "Abcd", 1);

        // Валидация с использованием аннотаций
        validateWithAnnotations(pathSegment);

        // Валидация с использованием XML
        validateWithXML(pathSegment2);
    }

    private static void validateWithAnnotations(PathSegment pathSegment) {
        System.out.println("Validating with annotations:");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<PathSegment>> violations = validator.validate(pathSegment);

        printViolations(violations);
    }

    private static void validateWithXML(PathSegment pathSegment) {
        System.out.println("Validating with XML:");
        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .addMapping(Main.class.getResourceAsStream("/META-INF/constraints.xml"))
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<PathSegment>> violations = validator.validate(pathSegment);

        printViolations(violations);
    }

    private static void printViolations(Set<ConstraintViolation<PathSegment>> violations) {
        if (violations.isEmpty()) {
            System.out.println("All validations passed successfully!");
        } else {
            for (ConstraintViolation<PathSegment> violation : violations) {
                System.out.println("Field: " + violation.getPropertyPath());
                System.out.println("Invalid value: " + violation.getInvalidValue());
                System.out.println("Error message: " + violation.getMessage());
                System.out.println();
            }
        }
    }
}
