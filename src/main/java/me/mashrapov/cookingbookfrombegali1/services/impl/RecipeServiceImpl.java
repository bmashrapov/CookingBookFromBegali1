package me.mashrapov.cookingbookfrombegali1.services.impl;
//import me.mashrapov.cookingbookfrombegali1.model.Ingredient;
import me.mashrapov.cookingbookfrombegali1.model.Recipe;
import me.mashrapov.cookingbookfrombegali1.services.RecipeService;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipeMap = new HashMap<>();
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

    @Override
    public List<Recipe> getAllRecipes() {
        return new ArrayList<>(recipeMap.values());
    }
    //++++++++++++++++++++++++++++++++++++++ additional tasks
//    @Override
//    public List<Recipe> getRecipesByIngredientId(int id) {
//        List<Recipe> recipesWithIngredient = new ArrayList<>();
//        for (Recipe recipe : recipeMap.values()) {
//            for (Ingredient ingredient : recipe.getIngredients()) {
//                if (ingredient.getId() == id) {
//                    recipesWithIngredient.add(recipe);
//                    break;
//                }
//            }
//        }
//        return recipesWithIngredient;
//    }
//
//    @Override
//    public List<Recipe> getRecipesByIngredients(List<Integer> ingredientIds) {
//        List<Recipe> recipesWithIngredients = new ArrayList<>();
//        for (Recipe recipe : recipeMap.values()) {
//            List<Integer> recipeIngredientIds = recipe.getIngredients().stream()
//                    .map(Ingredient::getId).toList();
//            if (new HashSet<>(recipeIngredientIds).containsAll(ingredientIds)) {
//                recipesWithIngredients.add(recipe);
//            }
//        }
//        return recipesWithIngredients;
//    }
//
//    @Override
//    public List<Recipe> getRecipesPaginated(int page, int size) {
//        List<Recipe> allRecipes = new ArrayList<>(recipeMap.values());
//        int startIndex = page * size;
//        if (startIndex >= allRecipes.size()) {
//            return Collections.emptyList();
//        }
//        int endIndex = Math.min(startIndex + size, allRecipes.size());
//        return allRecipes.subList(startIndex, endIndex);
//    }
}
