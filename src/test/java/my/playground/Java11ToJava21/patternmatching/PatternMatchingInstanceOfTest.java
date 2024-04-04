package my.playground.Java11ToJava21.patternmatching;

import my.playground.Java11ToJava21.patternmatching.dto.Developer;
import my.playground.Java11ToJava21.patternmatching.dto.Employee;
import my.playground.Java11ToJava21.patternmatching.dto.QA;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This Test class is designed for demonstration purposes, showcasing examples
 * of the instanceof operator usage: pre-pattern matching approach and pattern matching approach introduced in Java 14+.
 * These examples illustrate the syntax and functionality but are not intended as actual unit tests.
 */
public class PatternMatchingInstanceOfTest {

    @Test
    public void instanceofBeforeJava14() {
        var dev = new Developer("John Doe", "Java");
        printEmployeeDetailsBeforeJava14(dev);
    }

    @Test
    public void instanceofAfterJava14() {
        var qa = new QA("Sarah Connor", false);
       printEmployeeDetailsAfterJava14(qa);
    }

    @Test
    public void patternVariableScopes() {
        Employee employee = new Developer("John Doe", "Java");
        assertTrue(isJavaDeveloper(employee));

        if(employee instanceof Developer dev && dev.getMainProgrammingLanguage().equals("Java")) {
            System.out.println("Using pattern variable 'dev': " + dev);
        } else {
            System.out.println("Cannot use pattern variable");
        }
    }

    private boolean isJavaDeveloper(Employee employee) {
        if(! (employee instanceof Developer dev)) {
            //Cannot use pattern variable 'dev' here
            //System.out.println(dev);
            //Because predicate 'employee instanceof Developer' is false
            return false;
        }
        return dev.getMainProgrammingLanguage().equals("Java");
    }

    private void printEmployeeDetailsBeforeJava14(Employee employee) {
        if(employee instanceof Developer) {
            Developer dev = (Developer) employee;
            System.out.println(dev);
        } else if (employee instanceof QA) {
            QA qa = (QA) employee;
            System.out.println(qa);
        }
    }

    private void printEmployeeDetailsAfterJava14(Employee employee) {
        if(employee instanceof Developer dev) {
            System.out.println(dev);
        } else if (employee instanceof QA qa) {
            System.out.println(qa);
        } else {
            System.out.println("employee instance is neither Developer nor QA");
        }
    }
}
