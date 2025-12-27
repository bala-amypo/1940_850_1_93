package com.example.demo.controller;

import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.MedicationDto;
import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @PostMapping("/ingredient")
    public ResponseEntity<ActiveIngredient> addIngredient(@RequestBody IngredientDto dto) {
        ActiveIngredient ingredient = new ActiveIngredient(dto.getName());
        ActiveIngredient saved = catalogService.addIngredient(ingredient);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/medication")
    public ResponseEntity<Medication> addMedication(@RequestBody MedicationDto dto) {
        Medication medication = new Medication(dto.getName());
        dto.getIngredientIds().forEach(id -> {
            // In real impl, fetch ingredients by ID and add
            medication.addIngredient(new ActiveIngredient("Ingredient-" + id));
        });
        Medication saved = catalogService.addMedication(medication);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/medications")
    public ResponseEntity<List<Medication>> getAllMedications() {
        return ResponseEntity.ok(catalogService.getAllMedications());
    }
}
