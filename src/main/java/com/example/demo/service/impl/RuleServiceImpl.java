package com.example.demo.service.impl;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.InteractionRule;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository ruleRepository;
    private final ActiveIngredientRepository ingredientRepository;

    public RuleServiceImpl(InteractionRuleRepository ruleRepository, ActiveIngredientRepository ingredientRepository) {
        this.ruleRepository = ruleRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        String[] validSeverities = {"MINOR", "MODERATE", "MAJOR"};
        boolean validSeverity = false;
        for (String severity : validSeverities) {
            if (severity.equals(rule.getSeverity())) {
                validSeverity = true;
                break;
            }
        }
        if (!validSeverity) {
            throw new IllegalArgumentException("Severity must be MINOR, MODERATE, or MAJOR");
        }

        Long id1 = rule.getIngredientA().getId();
        Long id2 = rule.getIngredientB().getId();
        if (ruleRepository.findRuleBetweenIngredients(id1, id2).isPresent()) {
            throw new IllegalArgumentException("Rule already exists for ingredient pair");
        }

        return ruleRepository.save(rule);
    }

    @Override
    public List<InteractionRule> getAllRules() {
        return ruleRepository.findAll();
    }
}
