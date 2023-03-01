package me.mashrapov.cookingbookfrombegali1.services.impl;

import me.mashrapov.cookingbookfrombegali1.model.Ingredient;
import me.mashrapov.cookingbookfrombegali1.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private int idCounter = 1;

    @Override
    public int addIngredient(Ingredient ingredient) {
        ingredientMap.put(idCounter, ingredient);
        return idCounter++;
    }

    @Override
    public Ingredient getIngredientById(int id) {
        return ingredientMap.get(id);
    }
}
