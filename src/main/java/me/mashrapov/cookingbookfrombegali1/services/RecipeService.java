package me.mashrapov.cookingbookfrombegali1.services;

import me.mashrapov.cookingbookfrombegali1.model.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe getRecipeById(int id);

    int addRecipe(Recipe recipe);

    Recipe editRecipe(int id, Recipe recipe);

    boolean deleteRecipe(int id);

    List<Recipe> getAllRecipes();

//    List<Recipe> getRecipesByIngredientId(int id);
//
//    List<Recipe> getRecipesByIngredients(List<Integer> ingredientIds);
//
//    List<Recipe> getRecipesPaginated(int page, int size);
}
