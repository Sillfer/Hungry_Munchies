package com.hungry_munchies.Hungry_Munchies.entities;

import com.hungry_munchies.Hungry_Munchies.entities.parent.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Chef extends User { // inheritance from User class (parent)

    private String firstname;

    private String lastname;

    private String address;

    private Integer rating;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "chef")
    private List<Recipe> recipes;

}
