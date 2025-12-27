package com.example.demo.service;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;

public interface CatalogService {

    ActiveIngredient addIngredient(ActiveIngredient ingredient);

    Medication addMedication(Medication medication);
}
