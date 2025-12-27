package com.example.demo.dto;

public class IngredientDto {

    private String name;

    public IngredientDto() {
    }

    public IngredientDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
