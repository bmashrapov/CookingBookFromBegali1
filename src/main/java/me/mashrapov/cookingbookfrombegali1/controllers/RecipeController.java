package me.mashrapov.cookingbookfrombegali1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.mashrapov.cookingbookfrombegali1.model.Recipe;
import me.mashrapov.cookingbookfrombegali1.services.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Recipes", description = "CRUD operations and other endpoints related to recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    @Operation(summary = "Add a recipe", description = "Here you can add your recipe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The ID of the added recipe"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Integer> addRecipe(@RequestBody Recipe recipe) {
        int id = recipeService.addRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping
    @Operation(summary = "Get all recipes", description = "Here you can see your all recipes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of all recipes"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Recipe>> getAllRecipe() {
        List<Recipe> recipeList = new ArrayList<>(recipeService.getAllRecipes());
        return ResponseEntity.ok(recipeList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a recipe by ID", description = "Here you can see specified recipes by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The recipe with the specified ID"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Recipe> getRecipeById(@PathVariable int id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a recipe", description = "Here you can edite recipe by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The updated recipe"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Recipe> editRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a recipe", description = "Here you can delete recipe by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The recipe was deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteRecipe(@PathVariable int id) {
        if (recipeService.deleteRecipe(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    //++++++++++++++++++++++++++++ additional tasks
//    @GetMapping("/byIngredient/{id}")
//    public ResponseEntity<List<Recipe>> getRecipesByIngredientId(@PathVariable int id) {
//        List<Recipe> recipeList = new ArrayList<>(recipeService.getRecipesByIngredientId(id));
//        return ResponseEntity.ok(recipeList);
//    }
//
//    @GetMapping("/byIngredients")
//    public ResponseEntity<List<Recipe>> getRecipesByIngredients(@RequestParam List<Integer> ingredientIds) {
//        List<Recipe> recipeList = new ArrayList<>(recipeService.getRecipesByIngredients(ingredientIds));
//        return ResponseEntity.ok(recipeList);
//    }
//
//    @GetMapping("/paginate")
//    public ResponseEntity<List<Recipe>> getRecipesPaginated(@RequestParam(defaultValue = "0") int page) {
//        List<Recipe> recipeList = new ArrayList<>(recipeService.getRecipesPaginated(page, 10));
//        return ResponseEntity.ok(recipeList);
//    }
}
