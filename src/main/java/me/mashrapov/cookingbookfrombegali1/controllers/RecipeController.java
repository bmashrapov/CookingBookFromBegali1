package me.mashrapov.cookingbookfrombegali1.controllers;

import me.mashrapov.cookingbookfrombegali1.model.Recipe;
import me.mashrapov.cookingbookfrombegali1.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity<Integer> addRecipe(@RequestBody Recipe recipe) {
        int id = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
