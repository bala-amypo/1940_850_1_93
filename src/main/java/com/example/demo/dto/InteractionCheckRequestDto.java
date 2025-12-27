package com.example.demo.dto;

import java.util.List;

public class InteractionCheckRequestDto {

    private List<Long> medicationIds;

    public InteractionCheckRequestDto() {
    }

    public InteractionCheckRequestDto(List<Long> medicationIds) {
        this.medicationIds = medicationIds;
    }

    public List<Long> getMedicationIds() {
        return medicationIds;
    }

    public void setMedicationIds(List<Long> medicationIds) {
        this.medicationIds = medicationIds;
    }
}
