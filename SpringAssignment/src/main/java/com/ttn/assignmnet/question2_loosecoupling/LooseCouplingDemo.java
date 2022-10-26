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

import java.util.Arrays;

public class LooseCouplingDemo {
    public static void main(String[] args) {
        /*
            This is the code for calling the binarySearch algorithm which is used for searching an element of
            an arrayList.
            BinarySearch class have searching method which call the sorting method of bubbleSort class before
            searching because binarySearch work on sorted collections...

            BinarySearch binarySearch1 = new BinarySearch(new BubbleSort());

            IN above line we created an instance of BinarySearch class and in that class there is the
            constructor injection.
            we pass the BubbleSort class instance inside the constructor of BinarySearch class
            in that constructor we assign that instance to the reference variable of Sort interface
            that is why we call the sorting method of bubbleSort because Sort method reference variable
            is pointed to the bubbleSort instance because we pass bubbleSort instance inside binarySearch
            constructor
        */

        BinarySearch binarySearch1 = new BinarySearch(new BubbleSort());
        int target = ~22;
        int result = binarySearch1.searching(Arrays.asList(5, 4, 8, 1, 2, 3, -23, -555, 555), target);
        System.out.println("The index of element " + target + " in the list is " + result);


        /*
            This is the code for calling the binarySearch algorithm which is used for searching an element of
            an arrayList.
            BinarySearch class have searching method which call the sorting method of QuickSort class before
            searching because binarySearch work on sorted collections...

            BinarySearch binarySearch1 = new BinarySearch(new QuickSort());

            IN above line we created an instance of BinarySearch class and in that class there is the
            constructor injection.
            we pass the QuickSort class instance inside the constructor of BinarySearch class
            in that constructor we assign that instance to the reference variable of Sort interface
            that is why we call the sorting method of QuickSort because Sort method reference variable
            is pointed to the QuickSort instance because we pass QuickSort instance inside binarySearch
            constructor.
        */
        System.out.println("----------------------------");
        BinarySearch binarySearch2 = new BinarySearch(new QuickSort());
        target = 8;
        result = binarySearch2.searching(Arrays.asList(5, 4, 8, 1, 2, 3, -23, -555, 555), target);
        System.out.println("The index of element " + target + " in the list is " + result);
    }
}
