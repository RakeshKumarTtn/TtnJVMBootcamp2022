package org.example;


/*
    1. Add a maven dependency and its related repository URL.
    2. Add a new repository in the pom.xml and use its dependencies.
    3. Using JAR plugin, make changes in the pom.xml to make the jar executable. Using java -jar JAR_NAME, the output should be printed as "Hello World"
    4. Differentiate between the different dependency scopes: compile, runtime, test, provided using different dependencies being defined in your pom.xml.
    5. Create a MULTI-MODULE project. Run package command at the top level to make jar of every module.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}