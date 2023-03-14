package com.hungry_munchies.Hungry_Munchies.entities;

import com.hungry_munchies.Hungry_Munchies.enums.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    private String recipeName;

    @Column(columnDefinition = "TEXT")
    private String recipeDescription;

    private String difficulty;

    private String recipeImage;

    private Integer rating;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Chef chef;

    @ManyToOne
    private Manager manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return recipeId.equals(recipe.recipeId);
    }

}
