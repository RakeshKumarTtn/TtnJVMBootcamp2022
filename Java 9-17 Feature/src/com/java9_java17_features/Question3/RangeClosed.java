package com.java9_java17_features.Question3;

import java.util.stream.IntStream;

/*
Use rangeClosed to create a  Stream
rangeClosed Method include the starting and the ending value of the function like
rangeClosed(0,50) will include both 0 and 50 in the resultSet
while range(0,50) function not include 50 in the resultSet.
*/
public class RangeClosed {
    public static void main(String[] args) {
        IntStream
                .rangeClosed(0, 50)
                .filter(e -> e % 2 == 0)
                .filter(e -> e % 10 == 2)
                .forEach(System.out::println);
    }
}
