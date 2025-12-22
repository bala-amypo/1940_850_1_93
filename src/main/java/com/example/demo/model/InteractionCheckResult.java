package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class InteractionCheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medications;

    @Column(columnDefinition = "TEXT")
    private String interactions;

    private LocalDateTime checkedAt;

    @PrePersist
    void onCreate() {
        checkedAt = LocalDateTime.now();
    }

    public InteractionCheckResult() {}

    public InteractionCheckResult(String medications, String interactions) {
        this.medications = medications;
        this.interactions = interactions;
    }

    // ✅ GETTERS (THIS REMOVES THE WARNING)
    public Long getId() {
        return id;
    }

    public String getMedications() {
        return medications;
    }

    public String getInteractions() {
        return interactions;
    }

    public LocalDateTime getCheckedAt() {
        return checkedAt;
    }
    
    public void setId(Long id) { this.id = id; }
    public void setMedications(String medications) { this.medications = medications; }
    public void setInteractions(String interactions) { this.interactions = interactions; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}


