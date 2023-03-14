package com.hungry_munchies.Hungry_Munchies.serviceImp;

import com.hungry_munchies.Hungry_Munchies.entities.Recipe;
import com.hungry_munchies.Hungry_Munchies.repository.RecipeRepository;
import com.hungry_munchies.Hungry_Munchies.request.recipe.RecipeRequestDTO;
import com.hungry_munchies.Hungry_Munchies.response.recipe.RecipeResponseDTO;
import com.hungry_munchies.Hungry_Munchies.service.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImp implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RecipeResponseDTO createRecipe(RecipeRequestDTO recipeRequestDTO) {
        Recipe recipe = modelMapper.map(recipeRequestDTO, Recipe.class);
        recipe = recipeRepository.save(recipe);
        return modelMapper.map(recipe, RecipeResponseDTO.class);
    }

    @Override
    public List<RecipeResponseDTO> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream()
                .map(recipe -> modelMapper.map(recipe, RecipeResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeResponseDTO> findAllByChefId(Long search) {
        List<Recipe> recipes = recipeRepository.findAllByChefUserId(search);
        return recipes.stream()
                .map(recipe -> modelMapper.map(recipe, RecipeResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeResponseDTO> searchRecipes(String search) {
        List<Recipe> recipes = recipeRepository.findByRecipeNameContainingIgnoreCase(search);
        return recipes.stream()
                .map(recipe -> modelMapper.map(recipe, RecipeResponseDTO.class))
                .collect(Collectors.toList());
    }
}
