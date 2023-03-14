package com.hungry_munchies.Hungry_Munchies.response.recipe;

import com.hungry_munchies.Hungry_Munchies.enums.Category;
import com.hungry_munchies.Hungry_Munchies.response.chef.ChefResponseDTO;
import com.hungry_munchies.Hungry_Munchies.response.manager.ManagerResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeResponseDTO {

    private Long recipeId;

    private String recipeName;

    private String recipeDescription;

    private String difficulty;

    private String recipeImage;

    private Integer rating;

    private Category category;

    private ChefResponseDTO chef;

    private ManagerResponseDTO manager;
}

