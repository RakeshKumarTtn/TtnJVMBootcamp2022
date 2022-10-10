package com.java9_java17_features.Question8;

class Resource implements AutoCloseable {
    public Resource() {
        System.out.println("Resource1 Constructor...");
    }

    public void display() {
        System.out.println("Resource1 Displayed...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource1 Close Method Invoked...");
    }
}


class Resource2 implements AutoCloseable {
    public Resource2() {
        System.out.println("Resource2 Constructor...");
    }

    public void display() {
        System.out.println("Resource2 Displayed...");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource2 Close Method Invoked...");
    }
}

public class AutoCloseableDemo {

    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        Resource2 resource2 = new Resource2();
        try (resource; resource2) {
            resource.display();
            resource2.display();
        } catch (Exception ex) {

        }
    }
}