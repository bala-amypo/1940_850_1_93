package com.example.demo.service;

import com.example.demo.model.InteractionRule;
import java.util.List;

public interface RuleService {
    InteractionRule addRule(InteractionRule rule);
    List<InteractionRule> getAllRules();
    InteractionRule getRuleById(Long id);
    InteractionRule updateRule(Long id, InteractionRule rule);
    void deleteRule(Long id);
    List<InteractionRule> getRulesByIngredient(Long ingredientId);
}
