package com.example.demo.service.impl;

import com.example.demo.model.InteractionRule;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {

    @Autowired(required = false)
    private InteractionRuleRepository ruleRepository;

    // REQUIRED: No-args constructor
    public RuleServiceImpl() {}

    @Override
    public InteractionRule addRule(InteractionRule rule) {
        return rule;
    }
}
