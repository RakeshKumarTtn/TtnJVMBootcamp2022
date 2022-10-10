package com.java.collection.firstQuestion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FloatingPointListAddition {
    public static void main(String[] args) {

        //defining a list
        List<Float> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter How Many Number Do You Want tO Add In the List");
        int input = scanner.nextInt();
        System.out.println("Enter Values...");
        //Adding values in the list
        for (int i = 0; i < input; i++) {
            float value = scanner.nextFloat();
            list.add(value);
        }

        //defining the iterator and iterate through the list for finding the sum of all elements
        float sum = 0f;
        Iterator<Float> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum = sum + iterator.next();
        }
        System.out.println("Sum of All Elements of list = " + sum);
    }
}
