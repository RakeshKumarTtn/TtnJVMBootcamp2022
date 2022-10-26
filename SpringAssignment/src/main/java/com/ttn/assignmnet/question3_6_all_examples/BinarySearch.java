package com.ttn.assignmnet.question3_6_all_examples;

/*
    (3) Use @COMPONENT and @Autowired annotations to in Loosely Coupled code for dependency management
    (4) Get a Spring Bean from application context and display its properties.
    (5) Demonstrate how you will resolve ambiguity while autoWiring bean (Hint : @Primary)
    (6) Perform Constructor Injection in a Spring Bean
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
    @Component annotation is used for making class eligible for beans creation.
    Spring create beans for the classes which are annotated with @Component annotation
*/
@Component
public class BinarySearch {

    @Autowired
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
