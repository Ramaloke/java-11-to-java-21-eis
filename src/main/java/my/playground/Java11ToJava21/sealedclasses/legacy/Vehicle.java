package my.playground.Java11ToJava21.sealedclasses.legacy;

import my.playground.Java11ToJava21.annotations.Internal;

@Internal
public sealed interface Vehicle permits Car, Truck {
}
