package com.java9_java17_features.Question2;

import java.util.ArrayList;
import java.util.List;
/*
Perform takeWhile operations on stream:
TakeWhile is the function in the stream which is take the resultset until given
condition return the false
TakeWhile is based on PREDICATE functional Interface
*/

public class TakeWhile {
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

        list.stream().takeWhile(e -> e.length() == 4).forEach(System.out::println);
    }
}
