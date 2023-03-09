package me.mashrapov.cookingbookfrombegali1.services.impl;

import me.mashrapov.cookingbookfrombegali1.model.Recipe;
import me.mashrapov.cookingbookfrombegali1.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    private int idCounter = 0;

    @Override
    public int addRecipe(Recipe recipe) {
        recipeMap.put(idCounter, recipe);
        return idCounter++;
    }

    @Override
    public Recipe getRecipeById(int id) {
        return recipeMap.get(id);
    }

    @Override
    public Recipe editRecipe(int id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            return recipe;
        }
        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        if (recipeMap.containsKey(id)) {
            recipeMap.remove(id);
            return true;
        }
        return false;
    }
}
