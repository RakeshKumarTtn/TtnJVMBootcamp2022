package com.java9_java17_features.Question7;
/*
Use Of method to create List, Set and Map:
we have a OF method in the list set and map interfaces by which we can create these collections
 */

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OfMethod {
    public static void main(String[] args) {
        System.out.println(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).stream().filter(e -> e % 2 == 0).collect(Collectors.toList()));
        System.out.println(Set.of(1, 2, 3, 4, 5, 6).stream().filter(e -> e % 2 == 1).collect(Collectors.toList()));
        System.out.println(Map.of(1, 2, 3, 4, 5, 6));
    }
}
