package com.codecool.kitchenmanagement;

import java.util.Optional;

public interface IngredientStore {
    Optional<Ingredient> requestIngredient(Ingredient ingredient);
}
