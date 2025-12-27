package com.example.demo.service.impl;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired(required = false)
    private InteractionCheckResultRepository resultRepository;

    // REQUIRED: No-args constructor
    public InteractionServiceImpl() {}

    @Override
    public InteractionCheckResult checkInteractions(List<Long> medicationIds) {
        return new InteractionCheckResult();
    }

    @Override
    public InteractionCheckResult getResult(Long id) {
        return new InteractionCheckResult();
    }
}
