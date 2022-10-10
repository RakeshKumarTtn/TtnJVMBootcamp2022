package com.java9_java17_features.Question4;

/*
Use iterator stream method to generate a stream:
Like we have for loop for iterating the value
similarly we have Iterate method in the stream for iterate the stream with ease
*/

import java.util.stream.IntStream;

public class StreamIterator {
    public static void main(String[] args) {
        IntStream.iterate(1, e -> e <= 10, e -> e + 3).forEach(System.out::println);
    }
}
