package me.mashrapov.cookingbookfrombegali1.services;

import me.mashrapov.cookingbookfrombegali1.model.Ingredient;

import java.util.List;

public interface IngredientService {
    int addIngredient(Ingredient ingredient);

    List<Ingredient> getAllIngredients();

    Ingredient getIngredientById(int id);

    Ingredient editIngredient(int id, Ingredient ingredient);

    boolean deleteIngredient(int id);
}
