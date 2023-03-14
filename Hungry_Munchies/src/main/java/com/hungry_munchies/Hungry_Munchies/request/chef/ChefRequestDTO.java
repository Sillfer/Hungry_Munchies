package com.hungry_munchies.Hungry_Munchies.request.chef;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChefRequestDTO {

    private String username;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private Integer rating;
}
