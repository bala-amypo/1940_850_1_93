package com.example.demo.repository;

import com.example.demo.model.InteractionRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InteractionRuleRepository
        extends JpaRepository<InteractionRule, Long> {
    List<InteractionRule> findByIngredientA_Id(Long ingredientId);

    List<InteractionRule> findByIngredientB_Id(Long ingredientId);
    
    List<InteractionRule> findByIngredientA_IdOrIngredientB_Id(Long ingredientAId, Long ingredientBId);

    // unordered pair lookup
    Optional<InteractionRule> findByIngredientA_IdAndIngredientB_Id(
            Long ingredientAId,
            Long ingredientBId
    );
}
