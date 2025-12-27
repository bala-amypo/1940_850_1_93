package com.example.demo.dto;

import java.time.LocalDateTime;

public class InteractionResponseDto {

    private String medications;
    private String interactions;
    private LocalDateTime checkedAt;

    public InteractionResponseDto() {
    }

    public InteractionResponseDto(String medications, String interactions, LocalDateTime checkedAt) {
        this.medications = medications;
        this.interactions = interactions;
        this.checkedAt = checkedAt;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getInteractions() {
        return interactions;
    }

    public void setInteractions(String interactions) {
        this.interactions = interactions;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }

    public void setCheckedAt(LocalDateTime checkedAt) {
        this.checkedAt = checkedAt;
    }
}
