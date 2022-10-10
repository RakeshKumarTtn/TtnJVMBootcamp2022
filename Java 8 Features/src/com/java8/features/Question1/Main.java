package com.java8.features.Question1;

import com.java8.features.Question1.ConcatTwoString;
import com.java8.features.Question1.ConvertStringToUppercase;
import com.java8.features.Question1.GreaterNumber;
import com.java8.features.Question1.IncrementNumber;

public class Main {
    public static void main(String[] args) {
        GreaterNumber greaterNumber = (int a, int b) -> a > b;
        System.out.println(greaterNumber.greaterNumber(17, 89));

        IncrementNumber incrementNumber = (int a) -> a = a + 1;
        System.out.println(incrementNumber.incrementNumber(10));

        ConcatTwoString concatTwoString = (String string1, String string2) -> string1.concat(string2);
        System.out.println(concatTwoString.concatStrings("Hello ", "World"));

        ConvertStringToUppercase convertStringToUppercase = (String string) -> string.toUpperCase();
        System.out.println(convertStringToUppercase.convertStringToUppercase("Hello World"));
    }
}
