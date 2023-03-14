package com.hungry_munchies.Hungry_Munchies.request.recipe;

import com.hungry_munchies.Hungry_Munchies.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequestDTO {

    private String recipeName;

    private String recipeDescription;

    private String difficulty;

    private String recipeImage;

    private Integer rating;

    private Category category;

    private Long chefId;

    private Long managerId;
}
