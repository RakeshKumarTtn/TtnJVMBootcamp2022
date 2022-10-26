package com.ttn.assignmnet.question3_6_all_examples;

/*
    (3) Use @COMPONENT and @Autowired annotations to in Loosely Coupled code for dependency management
    (4) Get a Spring Bean from application context and display its properties.
    (5) Demonstrate how you will resolve ambiguity while autoWiring bean (Hint : @Primary)
    (6) Perform Constructor Injection in a Spring Bean
*/

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class BubbleSort implements Sort {
    //BubbleSort override sorting method which is provided by Sort interface to give own implementation
    @Override
    public void sorting(List<Integer> array) {
        System.out.println("BubbleSort is running.");
        bubbleSort(array);
    }

    //bubbleSort method is used for sorting an arrayList
    public static void bubbleSort(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = 0; j < array.size() - i - 1; j++)
                if (array.get(j + 1) < array.get(j))
                    swap(array, j, j + 1);
        }
    }

    //swap method is used for swapping elements of arrayList
    public static void swap(List<Integer> array, int index1, int index2) {
        Collections.swap(array, index1, index2);
    }
}
