package my.playground.Java11ToJava21.patternmatching;

import my.playground.Java11ToJava21.sealedclasses.legacy.Car;
import my.playground.Java11ToJava21.sealedclasses.legacy.Truck;
import my.playground.Java11ToJava21.sealedclasses.legacy.Vehicle;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * This Test class is designed for demonstration purposes, showcasing examples
 * of the Switch operator usage: pre-pattern matching approach and pattern matching approach introduced in Java 17+.
 * These examples illustrate the syntax and functionality but are not intended as actual unit tests.
 */
public class PatternMatchingSwitchTest {

    @RepeatedTest(value = 5)
    public void beforePatternMatchingWithoutSwitch() {
        Object obj = getRandomData();

        if(obj instanceof String s) {
            System.out.println("String: " + s);
        } else if (obj instanceof Integer i) {
            System.out.println("Integer: " + i);
        } else if (obj instanceof Long l) {
            System.out.println("Long: " + l);
        } else if (obj instanceof Double d) {
            System.out.println("Double: " + d);
        } else {
            System.out.println("Other type: " + obj.getClass().getSimpleName());
        }
    }

    @RepeatedTest(value = 5)
    public void beforePatternMatchingWithSwitch() {
        Object obj = getRandomData();

        final String className = obj.getClass().getSimpleName();
        switch (className) {
            case "String":
                System.out.println("String");
                break;
            case "Integer":
                System.out.println("Integer");
                break;
            case "Long":
                System.out.println("Long");
                break;
            case "Double":
                System.out.println("Double");
                break;
            default:
                System.out.println("Other type: " + className);
        }
    }

    @RepeatedTest(value = 5)
    public void patternMatchingSwitch() {
        Object obj = getRandomData();
        var result = switch(obj) {
            case String s -> "String: " + s;
            case Integer i -> "Integer: " + i;
            case Long l -> "Long: " + l;
            case Double d -> {
                //this is a code block
                String msg = "Double: " + d;
                yield msg;
            }
            default -> "Other type";
        };
        System.out.println(result);
    }

    @Test
    public void patternMatchingSwitchForSealedClasses() {
        Vehicle vehicle = createRandomVehicle();
        switch (vehicle) {
            case Car c -> System.out.println(c);
            case Truck t -> System.out.println(t);
        }
    }

    private Vehicle createRandomVehicle() {
        return new Random().nextInt(2) == 0
                ? new Car()
                : new Truck();
    }

    private Object getRandomData() {
        int randomResult = new Random().nextInt(4);
        return switch (randomResult) {
            case 0 -> "String object";
            case 1 -> 1; //Integer
            case 2 -> 1L; //Long
            default -> 1.0; //Double
        };
    }
}
