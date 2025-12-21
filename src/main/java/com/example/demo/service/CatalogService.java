package com.example.demo.service;

import com.example.demo.model.*;
import java.util.List;

public interface CatalogService {
    // ActiveIngredient CRUD
    ActiveIngredient addIngredient(ActiveIngredient ingredient);
    List<ActiveIngredient> getAllIngredients();
    ActiveIngredient getIngredientById(Long id);
    ActiveIngredient updateIngredient(Long id, ActiveIngredient ingredient);
    void deleteIngredient(Long id);
    
    // Medication CRUD
    Medication addMedication(Medication medication);
    List<Medication> getAllMedications();
    Medication getMedicationById(Long id);
    Medication updateMedication(Long id, Medication medication);
    void deleteMedication(Long id);
}
