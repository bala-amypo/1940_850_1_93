package com.example.demo.controller;

import com.example.demo.model.InteractionRule;
import com.example.demo.service.RuleService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<InteractionRule> addRule(
            @RequestBody InteractionRule rule) {
        return ResponseEntity.ok(ruleService.addRule(rule));
    }

    @GetMapping
    public ResponseEntity<List<InteractionRule>> getAllRules() {
        return ResponseEntity.ok(List.of());
    }
}
