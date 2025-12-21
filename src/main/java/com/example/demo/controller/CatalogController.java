package com.example.demo.controller;

import com.example.demo.model.ActiveIngredient;
import com.example.demo.model.Medication;
import com.example.demo.service.CatalogService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    // ActiveIngredient CRUD
    @PostMapping("/ingredient")
    @ResponseStatus(HttpStatus.CREATED)
    public ActiveIngredient addIngredient(@RequestBody ActiveIngredient ingredient) {
        return catalogService.addIngredient(ingredient);
    }
    
    @GetMapping("/ingredients")
    public List<ActiveIngredient> getAllIngredients() {
        return catalogService.getAllIngredients();
    }
    
    @GetMapping("/ingredient/{id}")
    public ActiveIngredient getIngredient(@PathVariable Long id) {
        return catalogService.getIngredientById(id);
    }
    
    @PutMapping("/ingredient/{id}")
    public ActiveIngredient updateIngredient(@PathVariable Long id, @RequestBody ActiveIngredient ingredient) {
        return catalogService.updateIngredient(id, ingredient);
    }
    
    @DeleteMapping("/ingredient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIngredient(@PathVariable Long id) {
        catalogService.deleteIngredient(id);
    }

    // Medication CRUD
    @PostMapping("/medication")
    @ResponseStatus(HttpStatus.CREATED)
    public Medication addMedication(@RequestBody Medication medication) {
        return catalogService.addMedication(medication);
    }

    @GetMapping("/medications")
    public List<Medication> getAllMedications() {
        return catalogService.getAllMedications();
    }
    
    @GetMapping("/medication/{id}")
    public Medication getMedication(@PathVariable Long id) {
        return catalogService.getMedicationById(id);
    }
    
    @PutMapping("/medication/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody Medication medication) {
        return catalogService.updateMedication(id, medication);
    }
    
    @DeleteMapping("/medication/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMedication(@PathVariable Long id) {
        catalogService.deleteMedication(id);
    }
}
