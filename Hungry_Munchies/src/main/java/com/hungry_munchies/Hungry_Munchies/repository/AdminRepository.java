package com.hungry_munchies.Hungry_Munchies.repository;

import com.hungry_munchies.Hungry_Munchies.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

        Admin findByEmail(String email);
}
