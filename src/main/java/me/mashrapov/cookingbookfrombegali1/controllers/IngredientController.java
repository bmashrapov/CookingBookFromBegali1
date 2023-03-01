package me.mashrapov.cookingbookfrombegali1.controllers;

import me.mashrapov.cookingbookfrombegali1.model.Ingredient;
import me.mashrapov.cookingbookfrombegali1.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping
    public ResponseEntity<Integer> addIngredient(@RequestBody Ingredient ingredient) {
        int id = ingredientService.addIngredient(ingredient);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        if (ingredient != null) {
            return new ResponseEntity<>(ingredient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
