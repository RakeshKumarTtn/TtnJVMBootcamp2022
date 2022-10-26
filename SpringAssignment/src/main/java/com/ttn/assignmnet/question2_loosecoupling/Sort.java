package com.ttn.assignmnet.question2_loosecoupling;

/*
    (1) Write a program to demonstrate Tightly Coupled code.
    (2) Write a program to demonstrate Loosely Coupled code.
    (3) Use @COMPONENT and @Autowired annotations to in Loosely Coupled code for dependency management
    (4) Get a Spring Bean from application context and display its properties.
    (5) Demonstrate how you will resolve ambiguity while autoWiring bean (Hint : @Primary)
    (6) Perform Constructor Injection in a Spring Bean
*/

//(2) Write a program to demonstrate Loosely Coupled code.

import java.util.List;

//sort is the interface which provide a method sorting for all the classes which implement that interface
public interface Sort {
    void sorting(List<Integer> array);
}
