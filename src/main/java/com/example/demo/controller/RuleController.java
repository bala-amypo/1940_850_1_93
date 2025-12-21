package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class RuleController {

    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InteractionRule addRule(@RequestBody InteractionRule rule) {
        return ruleService.addRule(rule);
    }

    @GetMapping
    public List<InteractionRule> getAllRules() {
        return ruleService.getAllRules();
    }
    
    @GetMapping("/{id}")
    public InteractionRule getRule(@PathVariable Long id) {
        return ruleService.getRuleById(id);
    }
    
    @PutMapping("/{id}")
    public InteractionRule updateRule(@PathVariable Long id, @RequestBody InteractionRule rule) {
        return ruleService.updateRule(id, rule);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
    }
    
    @GetMapping("/ingredient/{ingredientId}")
    public List<InteractionRule> getRulesByIngredient(@PathVariable Long ingredientId) {
        return ruleService.getRulesByIngredient(ingredientId);
    }
}
