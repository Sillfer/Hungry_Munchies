package com.hungry_munchies.Hungry_Munchies.service;

import com.hungry_munchies.Hungry_Munchies.request.recipe.RecipeRequestDTO;
import com.hungry_munchies.Hungry_Munchies.response.recipe.RecipeResponseDTO;

import java.util.List;


public interface  RecipeService {

    RecipeResponseDTO createRecipe(RecipeRequestDTO recipeRequestDTO);
    List<RecipeResponseDTO> getAllRecipes();
    List<RecipeResponseDTO> findAllByChefId(Long userId);
    List<RecipeResponseDTO> searchRecipes(String search);

}
