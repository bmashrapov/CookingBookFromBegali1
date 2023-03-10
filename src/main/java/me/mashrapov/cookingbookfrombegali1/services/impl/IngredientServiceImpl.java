package me.mashrapov.cookingbookfrombegali1.services.impl;

import me.mashrapov.cookingbookfrombegali1.model.Ingredient;
import me.mashrapov.cookingbookfrombegali1.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private int idCounter = 1;

    @Override
    public int addIngredient(Ingredient ingredient) {
        ingredientMap.put(idCounter, ingredient);
        return idCounter++;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return new ArrayList<>(ingredientMap.values());
    }

    @Override
    public Ingredient getIngredientById(int id) {
        return ingredientMap.get(id);
    }

    @Override
    public Ingredient editIngredient(int id, Ingredient ingredient) {
        if (ingredientMap.containsKey(id)) {
            ingredientMap.put(id, ingredient);
            return ingredient;
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(int id) {
        if (ingredientMap.containsKey(id)) {
            ingredientMap.remove(id);
            return true;
        }
        return false;
    }

}
