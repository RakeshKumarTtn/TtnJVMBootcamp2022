package com.java8.features.Question4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectEvenNumbersFromStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .stream().filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
