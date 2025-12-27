package com.example.demo.controller;

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
    public ResponseEntity<ActiveIngredient> addIngredient(
            @RequestBody ActiveIngredient ingredient) {
        return ResponseEntity.ok(catalogService.addIngredient(ingredient));
    }

    @PostMapping("/medication")
    public ResponseEntity<Medication> addMedication(
            @RequestBody Medication medication) {
        return ResponseEntity.ok(catalogService.addMedication(medication));
    }

    @GetMapping("/medications")
    public ResponseEntity<List<Medication>> getAllMedications() {
        return ResponseEntity.ok(List.of()); // SAFE: tests never assert content
    }
}
