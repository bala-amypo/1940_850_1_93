package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private final InteractionRuleRepository repo;

    public RuleServiceImpl(InteractionRuleRepository repo) {
        this.repo = repo;
    }

    public InteractionRule addRule(InteractionRule rule) {
        if (rule.getIngredientA() == null || rule.getIngredientB() == null)
            throw new ValidationException("Both ingredients are required");
        if (rule.getSeverity() == null || rule.getSeverity().trim().isEmpty())
            throw new ValidationException("Severity is required");
        return repo.save(rule);
    }

    public List<InteractionRule> getAllRules() {
        return repo.findAll();
    }
    
    public InteractionRule getRuleById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + id));
    }
    
    public InteractionRule updateRule(Long id, InteractionRule rule) {
        InteractionRule existing = getRuleById(id);
        if (rule.getIngredientA() != null) existing.setIngredientA(rule.getIngredientA());
        if (rule.getIngredientB() != null) existing.setIngredientB(rule.getIngredientB());
        if (rule.getSeverity() != null && !rule.getSeverity().trim().isEmpty()) {
            existing.setSeverity(rule.getSeverity());
        }
        if (rule.getDescription() != null) existing.setDescription(rule.getDescription());
        return repo.save(existing);
    }
    
    public void deleteRule(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("Rule not found: " + id);
        repo.deleteById(id);
    }
    
    public List<InteractionRule> getRulesByIngredient(Long ingredientId) {
        return repo.findByIngredientA_IdOrIngredientB_Id(ingredientId, ingredientId);
    }
}
