package com.java9_java17_features.Question12;

/*
Demonstrate the use of Sealed Classes.
Sealed Classes is used for providing permit for extending or not
which class extends me that is the permit a class can apply on the CHILD classes.
*/

sealed class Base permits Child_1, Child_2 {
    /*
    Now this class permit that only Child_1 and Child_2 can extend it and use its functionality
    */
}

final class Child_1 extends Base {
    /*
    Now this class needs to be final,sealed or non-sealed otherwise compile throw an error
    */
}

sealed class Child_2 extends Base permits GrandChild3 {
    /*
    This class is the child class of the base and permit GrandChild3 to be its child in future
    */
}

non-sealed class GrandChild3 extends Child_2 {
    /*
    Sealed classes is not extends only by permit given classes
    final class cannot extends
    non-sealed classes extends by any of the classes
    */
}

public class SealedClass {
    public static void main(String[] args) {

    }
}
