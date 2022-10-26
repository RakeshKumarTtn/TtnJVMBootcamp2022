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

//BinarySearch Class for searching an element of an arrayList
public class BinarySearch {

    //Reference Variable of Sort interface
    Sort sort;

    //This is constructor Injection
    public BinarySearch(Sort sort) {
        this.sort = sort;
    }

    //Method for searching an element from an arrayList
    public int searching(List<Integer> array, int target) {

        //sort arrayList before Searching because binarySearch work on sorted Collections
        sort.sorting(array);

        // Logic to search number with binary search
        int start = 0;
        int end = array.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array.get(mid) == target) {
                return mid;
            } else if (array.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
