package com.hungry_munchies.Hungry_Munchies.repository;

import com.hungry_munchies.Hungry_Munchies.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Manager findByEmail(String email);
}
