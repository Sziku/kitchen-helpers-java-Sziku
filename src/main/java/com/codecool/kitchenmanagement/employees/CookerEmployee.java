package com.codecool.kitchenmanagement.employees;

import java.time.LocalDate;

public abstract class CookerEmployee extends Employee{
    private boolean hasKnife;

    public CookerEmployee(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public void receiveKnife() {
        hasKnife = true;
    }

    public boolean hasKnife() {
        return hasKnife;
    }

    public final void cook() {
        if (!hasKnife) {
            var formatString = // extract to static final?
                    "Can't cook: The employee %s hasn't received their knife set yet.";
            var message = String.format(formatString, toString());
            throw new IllegalStateException(message);
        }
        cookWithKnives();
    }
    protected abstract void cookWithKnives();
}
