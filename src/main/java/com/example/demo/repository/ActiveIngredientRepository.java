package com.example.demo.repository;

import com.example.demo.model.ActiveIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActiveIngredientRepository extends JpaRepository<ActiveIngredient, Long> {

    Optional<ActiveIngredient> findByName(String name);

    boolean existsByName(String name);
}
