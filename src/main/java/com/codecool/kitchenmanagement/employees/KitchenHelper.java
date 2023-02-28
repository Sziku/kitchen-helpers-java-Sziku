package com.codecool.kitchenmanagement.employees;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import com.codecool.kitchenmanagement.Ingredient;

public class KitchenHelper extends Employee {
    private static final int MAX_NUMBER_OF_INGREDIENTS = 3;
    private final Random random = new Random(); // per-instance random state for refill
    private final Map<Ingredient, Integer> ingredients = new HashMap<>();

    public KitchenHelper(String name, LocalDate birthDate, int salary) {
        super(name, birthDate, salary);
        for (var ingredient: Ingredient.values()) {
            ingredients.put(ingredient, 0);
        }
    }

    public void refillIngredients() {
        for (var ingredient: Ingredient.values()) {
            var amount = random.nextInt(MAX_NUMBER_OF_INGREDIENTS+1);
            ingredients.merge(ingredient, amount,Math::max);
        }
    }

    public Optional<Ingredient> giveUpIngredient(Ingredient ingredient) {
        if (hasIngredient(ingredient)) {
            decreaseAmountOf(ingredient);
            return Optional.of(ingredient);
        }
        return Optional.empty();


    }

    public void yell() {
        System.out.println("We're all out!");
    }

    private boolean hasIngredient(Ingredient ingredient) {
        return ingredients.get(ingredient) > 0;
    }
    private void decreaseAmountOf(Ingredient ingredient) {
        var amount = ingredients.get(ingredient);
        if (amount == 0) {
            throw new IllegalStateException("Tried to decrease empty ingredient stock.");
        }
        ingredients.replace(ingredient, amount-1);

    }
}
