package com.bmn.decisionservice.controller;

import com.bmn.decisionservice.model.Decision;
import com.bmn.decisionservice.payload.DecisionRequest;
import com.bmn.decisionservice.service.DesisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decision")
public class DecisionController {
    private final DesisionService decisionService;

    public DecisionController(DesisionService decisionService) {
        this.decisionService = decisionService;
    }

    @PostMapping()
    public ResponseEntity<Decision> makeDecision(
            @RequestBody DecisionRequest decisionRequest) {

        Decision decision = decisionService.makeDecision(decisionRequest.getDossierRef(), decisionRequest.getDecision());
        return ResponseEntity.ok(decision);
    }
}
