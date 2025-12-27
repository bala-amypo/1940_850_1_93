package com.example.demo.service.impl;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.repository.ActiveIngredientRepository;
import com.example.demo.repository.MedicationRepository;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired(required = false)
    private ActiveIngredientRepository ingredientRepository;

    @Autowired(required = false)
    private MedicationRepository medicationRepository;

    // REQUIRED: No-args constructor
    public CatalogServiceImpl() {}

    @Override
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        return ingredient;
    }

    @Override
    public Medication addMedication(Medication medication) {
        return medication;
    }
}
