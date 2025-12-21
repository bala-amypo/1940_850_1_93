package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CatalogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final ActiveIngredientRepository ingRepo;
    private final MedicationRepository medRepo;

    public CatalogServiceImpl(ActiveIngredientRepository i, MedicationRepository m) {
        ingRepo = i;
        medRepo = m;
    }

    // ActiveIngredient CRUD
    public ActiveIngredient addIngredient(ActiveIngredient ingredient) {
        if (ingredient.getName() == null || ingredient.getName().trim().isEmpty())
            throw new ValidationException("Ingredient name is required");
        if (ingRepo.existsByName(ingredient.getName()))
            throw new ValidationException("Ingredient already exists");
        return ingRepo.save(ingredient);
    }
    
    public List<ActiveIngredient> getAllIngredients() {
        return ingRepo.findAll();
    }
    
    public ActiveIngredient getIngredientById(Long id) {
        return ingRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found: " + id));
    }
    
    public ActiveIngredient updateIngredient(Long id, ActiveIngredient ingredient) {
        ActiveIngredient existing = getIngredientById(id);
        if (ingredient.getName() != null && !ingredient.getName().trim().isEmpty()) {
            existing.setName(ingredient.getName());
        }
        return ingRepo.save(existing);
    }
    
    public void deleteIngredient(Long id) {
        if (!ingRepo.existsById(id))
            throw new ResourceNotFoundException("Ingredient not found: " + id);
        ingRepo.deleteById(id);
    }

    // Medication CRUD
    public Medication addMedication(Medication medication) {
        if (medication.getName() == null || medication.getName().trim().isEmpty())
            throw new ValidationException("Medication name is required");
        if (medication.getIngredients().isEmpty())
            throw new ValidationException("At least one ingredient required");
        return medRepo.save(medication);
    }

    public List<Medication> getAllMedications() {
        return medRepo.findAll();
    }
    
    public Medication getMedicationById(Long id) {
        return medRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Medication not found: " + id));
    }
    
    public Medication updateMedication(Long id, Medication medication) {
        Medication existing = getMedicationById(id);
        if (medication.getName() != null && !medication.getName().trim().isEmpty()) {
            existing.setName(medication.getName());
        }
        if (medication.getIngredients() != null && !medication.getIngredients().isEmpty()) {
            existing.setIngredients(medication.getIngredients());
        }
        return medRepo.save(existing);
    }
    
    public void deleteMedication(Long id) {
        if (!medRepo.existsById(id))
            throw new ResourceNotFoundException("Medication not found: " + id);
        medRepo.deleteById(id);
    }
}
