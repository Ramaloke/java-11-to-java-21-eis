package my.playground.Java11ToJava21.sealedclasses.legacy;

import my.playground.Java11ToJava21.annotations.Internal;

@Internal
public final class Car implements Vehicle {

    @Override
    public String toString() {
        return "Car";
    }
}
