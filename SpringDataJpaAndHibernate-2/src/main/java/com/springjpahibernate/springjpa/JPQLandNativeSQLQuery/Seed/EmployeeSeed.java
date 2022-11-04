package com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.Seed;

import com.springjpahibernate.springjpa.JPQLandNativeSQLQuery.entities.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class EmployeeSeed {

    private final Random r = new Random();

    public String getEmployeeFirstNames() {
        String[] employeesFirstNames = {
                "Rakesh",
                "AmritPal",
                "Vikas",
                "Sumit",
                "Keshav",
                "Dushyant",
                "Aditya",
                "Cherry",
                "Shradha",
                "Kiran",
                "Sunny",
                "Bunty",
                "Neha",
                "Mansi",
                "Sumit",
                "Muskan",
                "Harry",
                "Golu",
                "Akash",
                "Sourabh",
                "Virat",
                "Rohit",
                "Rahul",
                "Hardik",
                "Harman",
                "Richa",
                "Sapna",
                "Seema",
                "Sohan",
                "Kajal",
                "Varun",
                "Vijay",
                "Nonu",
                "Arjun",
                "Nitish",
                "Nitin",
                "Ajay",
                "Piyush",
                "Ranveer",
                "Gourav",
                "Sahil",
                "Raju",
                "Nikhil",
                "Manish",
                "Jitender",
                "Tanmay",
        };
        int index = getRandomIndex(0, employeesFirstNames.length - 1);
        return employeesFirstNames[index];
    }

    public String getEmployeeLastNames() {
        String[] employeesLastNames = {
                "Sharma",
                "Verma",
                "Gupta",
                "Prajapati",
                "Kumar",
                "Bhai",
                "Singh",
                "Lal",
                "Lamba",
                "Jain",
                "Nain",
                "Yadav",
                "Bhardwaj",
                "Pandit",
                "Bajpai",
                "Thakur",
                "Patel",
                "Chauhan",
                "Pandey",
                "Kaur",
                "Chopra",
                "Ghosh",
                "Deshmukh",
                "Chawla",
                "MukkerJee",
                "Mehta",
                "Ahuja",
                "Khatri",
                "Anand",
                "Agarwal",
                "Acharya",
                "Reddy",
                "Khan",
                "Devgan",
                "Roshan",
                "Shetty",
                "Patekar",
                "Kohli",
        };
        int index = getRandomIndex(0, employeesLastNames.length - 1);
        return employeesLastNames[index];
    }

    public String getLocation() {
        String[] location = {
                "Andaman and Nicobar Islands",
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chandigarh",
                "Chhattisgarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Delhi",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Ladakh",
                "Lakshadweep",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "Odisha",
                "Puducherry",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttarakhand",
                "West Bengal"
        };
        int index = getRandomIndex(0, location.length - 1);
        return location[index];
    }

    public String getDesignation() {
        String[] designation = {
                "Product Manager",
                "VP of Marketing",
                "VP of Engineering",
                "Director of Engineering",
                "Chief Architect",
                "Software Architect",
                "Engineering Project Manager",
                "Engineering Manager",
                "Technical Lead",
                "Engineering Lead",
                "Team Lead",
                "Principal Software Engineer",
                "Senior Software Engineer",
                "Senior Software Developer",
                "Software Engineer",
                "Software Developer",
                "Junior Software Developer",
                "Intern Software Developer"
        };
        int index = getRandomIndex(0, designation.length - 1);
        return designation[index];
    }

    public Integer getRandomIndex(int start, int end) {
        return r.nextInt(end - start) + start;
    }

    public Double getRandomSalary(Double start, Double end) {
        return r.nextDouble(end - start) + start;
    }

    public List<Employee> getEmployeeList(Integer totalEmployees) {
        List<Employee> employees = new ArrayList<>();
        for (int counter = 1; counter <= totalEmployees; counter++) {
            Employee emp = new Employee();
            emp.setAge(getRandomIndex(20, 100));
            emp.setFirstName(getEmployeeFirstNames());
            emp.setLastName(getEmployeeLastNames());
            emp.setSalary(getRandomSalary(10000D, 90000D));
            employees.add(emp);
        }
        return employees;
    }
}