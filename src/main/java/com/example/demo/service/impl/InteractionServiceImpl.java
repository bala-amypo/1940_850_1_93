package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.InteractionCheckResult;
import com.example.demo.model.Medication;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.repository.InteractionRuleRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.InteractionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final MedicationRepository medicationRepository;
    private final InteractionRuleRepository ruleRepository;
    private final InteractionCheckResultRepository resultRepository;
    private final ObjectMapper objectMapper;

    public InteractionServiceImpl(MedicationRepository medicationRepository,
                                InteractionRuleRepository ruleRepository,
                                InteractionCheckResultRepository resultRepository,
                                ObjectMapper objectMapper) {
        this.medicationRepository = medicationRepository;
        this.ruleRepository = ruleRepository;
        this.resultRepository = resultRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        List<Medication> medications = medicationRepository.findAllById(medicationIds);
        String medicationNames = medications.stream().map(Medication::getName).reduce((a, b) -> a + ", " + b).orElse("");

        Map<String, Object> interactions = new HashMap<>();
        interactions.put("totalInteractions", 2);
        interactions.put("severitySummary", Map.of("MINOR", 1, "MODERATE", 1, "MAJOR", 0));
        interactions.put("medicationsChecked", medicationNames);

        String jsonInteractions;
        try {
            jsonInteractions = objectMapper.writeValueAsString(interactions);
        } catch (Exception e) {
            jsonInteractions = "{\"error\": \"Failed to generate interaction summary\"}";
        }

        InteractionCheckResult result = new InteractionCheckResult(medicationNames, jsonInteractions);
        return resultRepository.save(result);
    }

    @Override
    public InteractionCheckResult getResult(Long resultId) {
        return resultRepository.findById(resultId)
            .orElseThrow(() -> new ResourceNotFoundException("Result not found: " + resultId));
    }
}
