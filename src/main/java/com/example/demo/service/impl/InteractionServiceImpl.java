package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.InteractionCheckResult;
import com.example.demo.repository.InteractionCheckResultRepository;
import com.example.demo.service.InteractionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    private final InteractionCheckResultRepository repo;

    public InteractionServiceImpl(InteractionCheckResultRepository repo) {
        this.repo = repo;
    }

    public InteractionCheckResult checkInteractions(List<Long> ids) {
        InteractionCheckResult result =
                new InteractionCheckResult(ids.toString(), "{}");
        return repo.save(result);
    }

    public InteractionCheckResult getResult(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Result not found: " + id));
    }
    
    public List<InteractionCheckResult> getAllResults() {
        return repo.findAll();
    }
    
    public void deleteResult(Long id) {
        if (!repo.existsById(id))
            throw new ResourceNotFoundException("Result not found: " + id);
        repo.deleteById(id);
    }
}
