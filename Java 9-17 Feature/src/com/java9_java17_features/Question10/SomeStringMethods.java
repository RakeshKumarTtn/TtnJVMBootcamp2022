package com.java9_java17_features.Question10;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SomeStringMethods {
    public static void main(String[] args) {

        /*
         repeat() method will concat same string with the previous one with N times
         N is the value which is given by developer in the repeat method
        */
        String str = "Hello World";
        System.out.println(str.repeat(2));
        System.out.println("----------------------\n");

        /*
        strip() method is used for ignoring the white spaces like simple spaces and the special whitespaces like
        \u2005 which is not ignored by the trim() method
        */
        String string = "\u2005\u2005\u2005\u2005  We are in TO THE NEW  ";
        System.out.println(string.strip());
        System.out.println("----------------------\n");

        /*
        isBlank() method return true if the string is blank
        it ignore all the whitespaces and then check
        */
        System.out.println("\n\u2005   ".isBlank());
        System.out.println("----------------------\n");

        /*
        indent() Method is used for give some spaces from the beginning of the string and removing some spaces from the string
        */
        String normalString = "I am very tired";
        System.out.println(normalString.indent(2));
        System.out.println("----------------------\n");

        /*
        transform() method is used for changing the string into another form
        */
        normalString = "Today is very hot day";
        List<String> list = normalString.transform(new TransformFunction());
        System.out.println(list);
        System.out.println("----------------------\n");


        String html =
                "\t<html>\n" +
                        "\t\t<body>\n" +
                        "\t\t\t<p>Hello World</p>\n" +
                        "\t\t</body>\n" +
                        "\t<html>";

        System.out.println(html);
        System.out.println("----------------------\n");
        System.out.println(html.stripIndent());
        System.out.println("----------------------\n");


        System.out.println("\"Hello \\n world \"");
        System.out.println("\"Hello \\n world \"".translateEscapes());
        System.out.println("----------------------\n");


        System.out.println(String.format("Java %s", "17"));
        System.out.println("Java %s".formatted("17"));
        System.out.println("----------------------\n");

        String stringSpaces = "\s\s\s\s\s\sThis is a sentence with space.";
        System.out.println(stringSpaces);
    }
}

class TransformFunction implements Function<String, List<String>> {

    @Override
    public List<String> apply(String t) {
        return Arrays.asList(t.split(" "));
    }

}
