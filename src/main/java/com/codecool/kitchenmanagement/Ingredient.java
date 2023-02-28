package com.codecool.kitchenmanagement;

import java.util.Random;

public enum Ingredient {
    MEAT,
    POTATO,
    CARROT;


    private static final Random RANDOM = new Random();

    Ingredient() {
    }

    public static Ingredient randomIngredient() {
        var allIngredients = Ingredient.values();
        var numOfIngredients = allIngredients.length;
        return allIngredients[RANDOM.nextInt(numOfIngredients)];
    }

}
