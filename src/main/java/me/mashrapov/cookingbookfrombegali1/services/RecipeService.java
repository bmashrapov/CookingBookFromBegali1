package me.mashrapov.cookingbookfrombegali1.services;

import me.mashrapov.cookingbookfrombegali1.model.Recipe;

public interface RecipeService {
    Recipe getRecipeById(int id);

    int addRecipe(Recipe recipe);

    Recipe editRecipe(int id, Recipe recipe);

    boolean deleteRecipe(int id);
}
