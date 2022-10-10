package com.java9_java17_features.Question9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
Create Unmodifiable List from a Steam : we can create unmodifiable list by using two ways:
1. copyOf method is used for creating the unmodifiable list after that we can not able to add elements in the list
2. Collectors.toUnmodifiableList() is also used for the same
*/

public class UnModifiable {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(
                List.copyOf(list));

        System.out.println(
                list.stream().filter(e -> e > 1).collect(Collectors.toUnmodifiableList()));
    }
}
