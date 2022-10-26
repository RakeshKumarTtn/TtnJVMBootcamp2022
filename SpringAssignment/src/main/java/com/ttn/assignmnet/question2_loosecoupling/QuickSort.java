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

import static java.util.Collections.swap;

//QuickSort class used for sorting an arrayList
public class QuickSort implements Sort {

    //Quicksort override sorting method which is provided by Sort interface to give own implementation
    @Override
    public void sorting(List<Integer> array) {
        System.out.println("QuickSort is running");
        quickSort(array, 0, array.size() - 1);
    }

    //This is the quickSort algorithm which is used to sort an arrayList
    private static void quickSort(List<Integer> numbers, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(numbers, left, right);
            quickSort(numbers, left, pivotIndex - 1);  //sort left of pivot
            quickSort(numbers, pivotIndex, right);  //sort right of pivot
        }
    }

    //Partition method is used for partitioning arrayList for find pivot value
    private static int partition(List<Integer> numbers, int left, int right) {
        int pivot = numbers.get(right);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (numbers.get(j) <= pivot) {
                //Swap method which is in Collections class for swapping elements of an arrayList
                swap(numbers, ++i, j);
            }
        }
        swap(numbers, ++i, right);
        return i;
    }
}
