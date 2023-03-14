package com.hungry_munchies.Hungry_Munchies.response.admin;

import com.hungry_munchies.Hungry_Munchies.enums.Role;
import com.hungry_munchies.Hungry_Munchies.response.manager.ManagerResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponseDTO {

    private Long adminId;

    private String username;

    private String email;

    private Role role;

    private List<ManagerResponseDTO> managers;
}
