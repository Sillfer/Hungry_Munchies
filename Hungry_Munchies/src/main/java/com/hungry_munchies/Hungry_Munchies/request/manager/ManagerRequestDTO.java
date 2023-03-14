package com.hungry_munchies.Hungry_Munchies.request.manager;

import com.hungry_munchies.Hungry_Munchies.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ManagerRequestDTO {

    private String username;

    private String email;

    private String password;

    private Category category;

    private Long adminId;
}
