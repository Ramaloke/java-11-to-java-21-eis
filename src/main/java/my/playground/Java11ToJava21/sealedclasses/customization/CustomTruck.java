package my.playground.Java11ToJava21.sealedclasses.customization;

import my.playground.Java11ToJava21.sealedclasses.legacy.Truck;

//It is allowed to extend from Truck since it is non-sealed
public class CustomTruck extends Truck {

    @Override
    public String toString() {
        return "Custom Truck";
    }
}