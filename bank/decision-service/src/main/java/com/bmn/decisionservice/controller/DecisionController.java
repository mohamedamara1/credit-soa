package com.bmn.decisionservice.controller;

import com.bmn.decisionservice.model.Decision;
import com.bmn.decisionservice.service.DesisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/decision")
public class DecisionController {
    private final DesisionService decisionService;

    public DecisionController(DesisionService decisionService) {
        this.decisionService = decisionService;
    }

    @PostMapping("/{dossierReference}/{score}")
    public ResponseEntity<Decision> makeDecision(
            @PathVariable Long dossierReference,
            @PathVariable String score) {

        Decision decision = decisionService.makeDecision(dossierReference, score);
        return ResponseEntity.ok(decision);
    }
}
