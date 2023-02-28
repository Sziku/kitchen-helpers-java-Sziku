package com.codecool.kitchenmanagement.employees;

import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private LocalDate birthDate;
    private int salary;

    public Employee(String name, LocalDate birthDate, int salary) {
        this.name = name;
        this.birthDate = birthDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public LocalDate getbirthDate() {
        return birthDate;
    }

    public int getSalary() {
        return salary;
    }


    public void setSalary(int salary) {
        this.salary = salary;
    }


    public void printTax() {
        int tax = (int) (salary * 0.99);
        System.out.format("My tax is %d.%s", tax, System.lineSeparator());
    }


    @Override
    public String toString() {
        return String.format("Employee { name = &quot;%s&quot;, year of birth = %d }",
                name, birthDate.getYear());
    }




}
