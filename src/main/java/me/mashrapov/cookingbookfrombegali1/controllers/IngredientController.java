package me.mashrapov.cookingbookfrombegali1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.mashrapov.cookingbookfrombegali1.model.Ingredient;
import me.mashrapov.cookingbookfrombegali1.services.IngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Ingredients", description = "CRUD operations and other endpoints related to ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    @Operation(summary = "Add a ingredient", description = "Here you can add your ingredient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The ID of the added ingredient"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Integer> addIngredient(@RequestBody Ingredient ingredient) {
        int id = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a ingredient by ID", description = "Here you can see specified ingredient by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The ingredient with the specified ID"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        if (ingredient != null) {
            return ResponseEntity.ok(ingredient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @Operation(summary = "Get all ingredients", description = "Here you can see your all ingredients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The list of all ingredients"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredientList = new ArrayList<>(ingredientService.getAllIngredients());
        return ResponseEntity.ok(ingredientList);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a ingredient", description = "Here you can edite ingredient by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The updated ingredient"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Ingredient> editIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        ingredientService.getIngredientById(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a ingredient", description = "Here you can delete ingredient by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The ingredient was deleted"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteIngredient(@PathVariable int id) {
        if (ingredientService.deleteIngredient(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
