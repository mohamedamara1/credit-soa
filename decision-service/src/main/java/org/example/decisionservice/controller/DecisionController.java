package org.example.decisionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.decisionservice.service.DecisionService;
import org.example.decisionservice.dto.DecisionDTO;
import org.example.decisionservice.model.Decision;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/decisions")
public class DecisionController {

    @Autowired
    private DecisionService decisionService;

    @PostMapping
    public DecisionDTO createDecision(@RequestBody DecisionDTO decisionDTO) {
        Decision decision = convertToEntity(decisionDTO);
        Decision createdDecision = decisionService.createDecision(decision);
        return convertToDTO(createdDecision);
    }

    @GetMapping("/{id}")
    public DecisionDTO getDecision(@PathVariable String id) {
        Decision decision = decisionService.getDecision(id);
        return convertToDTO(decision);
    }

    @GetMapping
    public List<DecisionDTO> getAllDecisions() {
        List<Decision> decisions = decisionService.getAllDecisions();
        return decisions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public DecisionDTO updateDecision(@PathVariable String id, @RequestBody DecisionDTO decisionDTO) {
        Decision decision = convertToEntity(decisionDTO);
        Decision updatedDecision = decisionService.updateDecision(id, decision);
        return convertToDTO(updatedDecision);
    }

    @DeleteMapping("/{id}")
    public void deleteDecision(@PathVariable String id) {
        decisionService.deleteDecision(id);
    }

    private DecisionDTO convertToDTO(Decision decision) {
        DecisionDTO decisionDTO = new DecisionDTO();
        decisionDTO.setId(decision.getId());
        decisionDTO.setCreditId(decision.getCreditId());
        decisionDTO.setDecisionDate(decision.getDecisionDate());
        decisionDTO.setStatus(decision.getStatus());
        return decisionDTO;
    }

    private Decision convertToEntity(DecisionDTO decisionDTO) {
        Decision decision = new Decision();
        decision.setId(decisionDTO.getId());
        decision.setCreditId(decisionDTO.getCreditId());
        decision.setDecisionDate(decisionDTO.getDecisionDate());
        decision.setStatus(decisionDTO.getStatus());
        return decision;
    }
}
