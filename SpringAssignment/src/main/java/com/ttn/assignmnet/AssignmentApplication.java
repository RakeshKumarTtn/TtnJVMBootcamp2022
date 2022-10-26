package com.ttn.assignmnet;

import com.ttn.assignmnet.question3_6_all_examples.BinarySearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class AssignmentApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AssignmentApplication.class, args);
        BinarySearch binarySearch = applicationContext.getBean(BinarySearch.class);

        int target = 33;
        int result = binarySearch.searching(Arrays.asList(4, 5, 6, 7, 8, 1, 2, 33, 44, 66), target);
        System.out.println("The index of element " + target + " in the list is " + result);
    }
}
