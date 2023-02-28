package com.codecool.kitchenmanagement.employees;

import java.time.LocalDate;

public class Cook extends CookerEmployee{

    public Cook(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public void cookWithKnives() {
        System.out.println("I'm cooking");
        // might expand on it in later sprints
    }



}
