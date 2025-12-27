package com.example.demo.dto;

import java.util.List;

public class MedicationDto {

    private String name;
    private List<Long> ingredientIds;

    public MedicationDto() {
    }

    public MedicationDto(String name, List<Long> ingredientIds) {
        this.name = name;
        this.ingredientIds = ingredientIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
}
