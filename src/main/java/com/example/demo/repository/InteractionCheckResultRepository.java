package com.example.demo.repository;

import com.example.demo.model.InteractionCheckResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InteractionCheckResultRepository
        extends JpaRepository<InteractionCheckResult, Long> {
    // No extra methods required
}
