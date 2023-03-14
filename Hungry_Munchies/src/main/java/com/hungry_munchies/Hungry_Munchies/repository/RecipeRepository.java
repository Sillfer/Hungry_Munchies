package com.hungry_munchies.Hungry_Munchies.repository;

import com.hungry_munchies.Hungry_Munchies.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

       List<Recipe> findAllByChefUserId(Long userId);
       List<Recipe> findByRecipeNameContainingIgnoreCase(String search);
}
