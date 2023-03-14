package com.hungry_munchies.Hungry_Munchies.repository;

import com.hungry_munchies.Hungry_Munchies.entities.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChefRepository extends JpaRepository<Chef, Long> {

    Optional<Chef> findByEmail(String email);
}
