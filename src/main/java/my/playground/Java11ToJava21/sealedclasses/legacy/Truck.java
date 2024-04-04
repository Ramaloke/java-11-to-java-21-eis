package my.playground.Java11ToJava21.sealedclasses.legacy;

import my.playground.Java11ToJava21.annotations.CanExtend;

@CanExtend
public non-sealed class Truck implements Vehicle {

    @Override
    public String toString() {
        return "Truck";
    }
}
