package com.hungry_munchies.Hungry_Munchies.request.admin;

import com.hungry_munchies.Hungry_Munchies.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequestDTO {

    private String username;

    private String email;

    private String password;

    private Role role;

    private List<Long> managerIds;
}
