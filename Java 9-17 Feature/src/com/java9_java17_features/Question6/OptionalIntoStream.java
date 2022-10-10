package com.java9_java17_features.Question6;

/*
Convert an Optional type into Stream
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class OptionalIntoStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Think", "Eat", "Sleep", "Talk");
        list.stream()
                .filter(e -> e.length() != 0)
                .findFirst()
                .stream()
                .mapMulti((number, cosumer) -> IntStream.rangeClosed(1, 1)
                .forEach(e -> cosumer.accept(number.concat("ing"))))
                .forEach(System.out::println);
    }
}
