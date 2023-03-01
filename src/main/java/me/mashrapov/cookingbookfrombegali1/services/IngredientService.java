package me.mashrapov.cookingbookfrombegali1.services;

import me.mashrapov.cookingbookfrombegali1.model.Ingredient;

public interface IngredientService {
    int addIngredient(Ingredient ingredient);

    Ingredient getIngredientById(int id);
}
