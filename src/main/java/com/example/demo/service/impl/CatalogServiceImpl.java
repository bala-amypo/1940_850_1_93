package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final ActiveIngredientRepository ingredientRepository;
    private final MedicationRepository medicationRepository;

    public CatalogServiceImpl(ActiveIngredientRepository ingredientRepository, MedicationRepository medicationRepository) {
        this.ingredientRepository = ingredientRepository;
        this.medicationRepository = medicationRepository;
    }

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        if (ingredientRepository.existsByName(ingredient.getName())) {
            throw new ResourceNotFoundException("Ingredient already exists: " + ingredient.getName());
        }
        if (ingredient.getIngredients() == null || ingredient.getIngredients().isEmpty()) {
            throw new IllegalArgumentException("Medication must have at least one ingredient");
        }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Medication addMedication(Medication medication) {
        if (medication.getIngredients() == null || medication.getIngredients().isEmpty()) {
            throw new IllegalArgumentException("Medication must have at least one ingredient");
        }
        return medicationRepository.save(medication);
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }
}
