package com.hungry_munchies.Hungry_Munchies.controllers;

import com.hungry_munchies.Hungry_Munchies.request.recipe.RecipeRequestDTO;
import com.hungry_munchies.Hungry_Munchies.response.recipe.RecipeResponseDTO;
import com.hungry_munchies.Hungry_Munchies.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping
    public ResponseEntity<RecipeResponseDTO> createRecipe(@RequestBody RecipeRequestDTO recipeRequestDTO) {
        RecipeResponseDTO response = recipeService.createRecipe(recipeRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RecipeResponseDTO>> getAllRecipes() {
        List<RecipeResponseDTO> response = recipeService.getAllRecipes();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/chef{userId}")
    public ResponseEntity<List<RecipeResponseDTO>> findAllByChefId(@PathVariable Long userId) {
        List<RecipeResponseDTO> response = recipeService.findAllByChefId(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RecipeResponseDTO>> searchRecipes(@RequestParam("search") String search) {
        List<RecipeResponseDTO> response = recipeService.searchRecipes(search);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
