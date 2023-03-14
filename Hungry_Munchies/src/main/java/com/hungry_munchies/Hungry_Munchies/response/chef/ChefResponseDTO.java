package com.hungry_munchies.Hungry_Munchies.response.chef;

import com.hungry_munchies.Hungry_Munchies.response.recipe.RecipeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChefResponseDTO {

    private Long userId;

    private String username;

    private String firstName;

    private String lastName;

    private String address;

    private Integer rating;

    private List<RecipeResponseDTO> recipes;


}
