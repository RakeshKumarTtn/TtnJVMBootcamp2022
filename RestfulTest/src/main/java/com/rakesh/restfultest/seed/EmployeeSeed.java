package com.rakesh.restfultest.seed;

import com.rakesh.restfultest.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeSeed {

    List<Employee> Employees = new ArrayList<>();

    public List<Employee> getEmployeesList() {
        String[] marvelNames = {
                "THOR", "IRON MAN", "DEADPOOL",
                "DOCTOR STRANGE", "CAPTAIN AMERICA",
                "SPIDER-MAN", "VENOM", "X-MAN",
                "GHOST RIDER", "THE WOLVERINE",
                "HULK", "LOGAN"
        };

        for (int i = 0; i < marvelNames.length; i++) {
            Random r = new Random();
            int low = 15;
            int high = 50;
            int result = r.nextInt(high - low) + low;
            Employee emp = new Employee(i + 1, marvelNames[i], result);
            this.Employees.add(emp);
        }
        return this.Employees;
    }


}
