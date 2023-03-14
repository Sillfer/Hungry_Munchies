package com.hungry_munchies.Hungry_Munchies.entities;

import com.hungry_munchies.Hungry_Munchies.entities.parent.User;
import com.hungry_munchies.Hungry_Munchies.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Manager extends User {

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manager")
    private List<Recipe> recipes;

    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin admin;
}
