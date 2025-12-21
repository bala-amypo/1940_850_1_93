package com.example.demo.repository;

import com.example.demo.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository
        extends JpaRepository<Medication, Long> {
}
