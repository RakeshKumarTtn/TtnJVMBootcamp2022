package com.ttn.assignmnet.question1_tight_coupling;

/*
    (1) Write a program to demonstrate Tightly Coupled code.
    (2) Write a program to demonstrate Loosely Coupled code.
    (3) Use @COMPONENT and @Autowired annotations to in Loosely Coupled code for dependency management
    (4) Get a Spring Bean from application context and display its properties.
    (5) Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)
    (6) Perform Constructor Injection in a Spring Bean
*/

// (1) Write a program to demonstrate Tightly Coupled code.
public class Library {
    public static void main(String[] args) {

        /*
            Here we create an instance of MathematicsBook class that is the main problem of tight coupling
            we always create object using new keyword in purpose of calling the specific method of a particular
            class...
            later we use loose coupling for solve the problem of tight coupling
        */
        MathematicsBook mathematicsBook =
                new MathematicsBook("RD Sharma", "Mathematics for 10th", 1200D);

        //print the details of mathematicsBook instance(because toString is override by MathematicsBook class.)
        System.out.println(mathematicsBook);

        /*
            Here we create an instance of PhysicsBook class that is the main problem of tight coupling
            we always create object using new keyword in purpose of calling the specific method of a particular
            class...
            later we use loose coupling for solve the problem of tight coupling
        */
        PhysicsBook physicsBook =
                new PhysicsBook("Joe Walker", "Magnetism", 1550D);

        //print the details of physicsBook instance(because toString is override by PhysicsBook class.)
        System.out.println(physicsBook);
    }
}
