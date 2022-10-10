package com.java9_java17_features.Question5;

import java.util.stream.IntStream;

/*
Use orElseThrow Operations with Optional:
We have orElseThrow which is used in stream for checking some result coming from the resultSet or not
if it FInd then print otherwise throw a below exception:
Exception in thread "main" java.util.NoSuchElementException: No value present
*/
public class OrElseThrow {
    public static void main(String[] args) {

        System.out.println(
                IntStream
                        .rangeClosed(1, 20)
                        .filter(e -> e > 19)
                        .findFirst().orElseThrow());

        IntStream
                .rangeClosed(1, 20)
                .filter(e -> e > 50)
                .findFirst().orElseThrow();
    }
}
