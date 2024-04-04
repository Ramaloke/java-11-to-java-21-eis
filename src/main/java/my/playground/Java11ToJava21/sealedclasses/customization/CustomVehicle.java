package my.playground.Java11ToJava21.sealedclasses.customization;

import my.playground.Java11ToJava21.sealedclasses.legacy.Vehicle;

//It is prohibited to implement Vehicle since it is sealed
//and doesn't have 'CustomVehicle' class in the allowed classes hierarchy
public class CustomVehicle /*implements Vehicle*/ {
}
