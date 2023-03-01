package me.mashrapov.cookingbookfrombegali1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String nameOfIngredient;
    private int quantity;
    private String unitOfMeasure;
}
