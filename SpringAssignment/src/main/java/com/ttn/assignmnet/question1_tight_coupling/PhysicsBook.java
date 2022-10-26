package com.ttn.assignmnet.question1_tight_coupling;

/*
    (1) Write a program to demonstrate Tightly Coupled code.
    (2) Write a program to demonstrate Loosely Coupled code.
    (3) Use @COMPONENT and @Autowired annotations to in Loosely Coupled code for dependency management
    (4) Get a Spring Bean from application context and display its properties.
    (5) Demonstrate how you will resolve ambiguity while autowiring bean (Hint : @Primary)
    (6) Perform Constructor Injection in a Spring Bean
*/

// (1) Write a program to demonstrate Tightly Coupled code.
public class PhysicsBook {
    private String author;
    private String title;
    private double price;

    //Constructor for initialising the value of instances
    public PhysicsBook(String author, String title, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    //Getter for fetching the author name of the name
    public String getAuthor() {
        return author;
    }

    //Getter for fetching the title name of the book
    public String getTitle() {
        return title;
    }

    //Getter for fetching the price of the book
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PhysicsBook{\n\t " +
                "author='" + author + '\'' +
                ",\n\t title='" + title + '\'' +
                ",\n\t price=" + price +
                "\n}";
    }
}

