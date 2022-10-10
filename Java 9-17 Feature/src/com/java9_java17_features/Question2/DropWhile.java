package com.java9_java17_features.Question2;
/*
Perform dropWhile operations on stream:
DropWhile is a PREDICATE functional interface which will return boolean result
according to the condition
DropWhile drop the element from the given set until the condition return the true
*/

import java.util.ArrayList;
import java.util.List;

public class DropWhile {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>() {
            {
                add("Ajay");
                add("Renu");
                add("Saan");
                add("Rakesh");
                add("Amrit");
                add("Golu");
            }
        };
        System.out.println(list);

        list.stream().dropWhile(e -> e.length() == 4).forEach(System.out::println);
    }
}

