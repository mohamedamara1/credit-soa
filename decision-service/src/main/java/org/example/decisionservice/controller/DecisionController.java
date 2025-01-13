package org.example.decisionservice.controller;

import org.example.decisionservice.dto.DecisionDTO;
import org.example.decisionservice.service.DecisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/decisions")
public class DecisionController {

    @Autowired
    private DecisionService decisionService;

    @PostMapping
    public DecisionDTO createDecision(@RequestBody DecisionDTO decisionDTO) {
        return decisionService.createDecision(decisionDTO);
    }

    @GetMapping("/{id}")
    public DecisionDTO getDecision(@PathVariable String id) {
        return decisionService.getDecision(id);
    }

    @GetMapping
    public List<DecisionDTO> getAllDecisions() {
        return decisionService.getAllDecisions();
    }

    @PutMapping("/{id}")
    public DecisionDTO updateDecision(@PathVariable String id, @RequestBody DecisionDTO decisionDTO) {
        return decisionService.updateDecision(id, decisionDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDecision(@PathVariable String id) {
        decisionService.deleteDecision(id);
    }
}
