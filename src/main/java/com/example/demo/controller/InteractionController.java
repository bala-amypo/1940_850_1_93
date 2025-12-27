package com.example.demo.controller;

import com.example.demo.model.InteractionCheckResult;
import com.example.demo.service.InteractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interact")
public class InteractionController {

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping("/check")
    public ResponseEntity<InteractionCheckResult> checkInteractions(@RequestBody List<Long> medicationIds) {
        InteractionCheckResult result = interactionService.checkInteractions(medicationIds);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/result/{id}")
    public ResponseEntity<InteractionCheckResult> getResult(@PathVariable Long id) {
        InteractionCheckResult result = interactionService.getResult(id);
        return ResponseEntity.ok(result);
    }
}
