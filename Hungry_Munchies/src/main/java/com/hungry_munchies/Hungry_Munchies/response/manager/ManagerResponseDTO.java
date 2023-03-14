package com.hungry_munchies.Hungry_Munchies.response.manager;

import com.hungry_munchies.Hungry_Munchies.enums.Category;
import com.hungry_munchies.Hungry_Munchies.response.admin.AdminResponseDTO;
import com.hungry_munchies.Hungry_Munchies.response.recipe.RecipeResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDTO {

    private Long userId;

    private String username;

    private String email;

    private Category category;

    private List<RecipeResponseDTO> recipes;

    private AdminResponseDTO admin;
}
