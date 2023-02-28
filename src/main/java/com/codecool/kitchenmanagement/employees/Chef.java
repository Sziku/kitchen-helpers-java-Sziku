package com.codecool.kitchenmanagement.employees;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import com.codecool.kitchenmanagement.Ingredient;
import com.codecool.kitchenmanagement.IngredientStore;

public class Chef extends CookerEmployee {
    // instance-wise random for requests
    private final Random random = new Random();
    // initialized to null
    private IngredientStore store;

    public Chef(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
    }

    public void setStore(IngredientStore store) {
        this.store = store;
    }

    @Override
    protected void cookWithKnives() {
        // not specified when, so going 50-50
        var shouldAskForIngredient = random.nextBoolean();

        if (!shouldAskForIngredient || store == null) {
            return;
        }

        System.out.format("I need %s", Ingredient.randomIngredient());
            Optional<Ingredient> received = store.requestIngredient(Ingredient.randomIngredient());
            String ingredientName = received.map(Enum::name)
                    .orElse("NOTHING");
            System.out.println("I got " + ingredientName);

    }
}