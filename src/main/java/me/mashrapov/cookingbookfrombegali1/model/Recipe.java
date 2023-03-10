package me.mashrapov.cookingbookfrombegali1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Recipe {
    private int id;
    private String nameOfRecipe;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;
}
