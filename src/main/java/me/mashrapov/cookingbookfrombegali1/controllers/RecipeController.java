package me.mashrapov.cookingbookfrombegali1.controllers;

import me.mashrapov.cookingbookfrombegali1.model.Recipe;
import me.mashrapov.cookingbookfrombegali1.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Integer> addRecipe(@RequestBody Recipe recipe) {
        int id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipe() {
        List<Recipe> recipeList = new ArrayList<>(recipeService.getAllRecipes());
        return ResponseEntity.ok(recipeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    //++++++++++++++++++++++++++++ additional tasks
    @GetMapping("/byIngredient/{id}")
    public ResponseEntity<List<Recipe>> getRecipesByIngredientId(@PathVariable int id) {
        List<Recipe> recipeList = new ArrayList<>(recipeService.getRecipesByIngredientId(id));
        return ResponseEntity.ok(recipeList);
    }

    @GetMapping("/byIngredients")
    public ResponseEntity<List<Recipe>> getRecipesByIngredients(@RequestParam List<Integer> ingredientIds) {
        List<Recipe> recipeList = new ArrayList<>(recipeService.getRecipesByIngredients(ingredientIds));
        return ResponseEntity.ok(recipeList);
    }

    @GetMapping("/paginate")
    public ResponseEntity<List<Recipe>> getRecipesPaginated(@RequestParam(defaultValue = "0") int page) {
        List<Recipe> recipeList = new ArrayList<>(recipeService.getRecipesPaginated(page, 10));
        return ResponseEntity.ok(recipeList);
    }
}
