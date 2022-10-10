package com.java8.features.Question4;

public class Employee {

    private long salary;
    private String city;
    private FullName fullName;

    //FullName As Inner Class so that Firstname,MiddleName and Lastname Hierarchy Maintain
    public static class FullName {
        private String firstName;
        private String middleName;
        private String lastName;

        public FullName(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return firstName + " " + middleName + " " + lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    public Employee(String fullName, long salary, String city) {
        String[] array = fullName.split(" ");
        if (array.length >= 3) {
            this.fullName = new Employee.FullName(array[0], array[1], array[2]);
        } else if (array.length == 2) {
            this.fullName = new Employee.FullName(array[0], array[1], "");
        } else if (array.length == 1) {
            this.fullName = new Employee.FullName(array[0], "", "");
        } else {
            this.fullName = new Employee.FullName("", "", "");
        }

        this.salary = salary;
        this.city = city;
    }

    public long getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    public FullName getFullName() {
        return fullName;
    }
}
