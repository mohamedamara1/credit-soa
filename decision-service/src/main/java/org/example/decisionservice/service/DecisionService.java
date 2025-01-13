package org.example.decisionservice.service;

import org.example.decisionservice.dto.DecisionDTO;
import org.example.decisionservice.model.Decision;
import org.example.decisionservice.repository.DecisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DecisionService {

    @Autowired
    private DecisionRepository decisionRepository;

    public DecisionDTO createDecision(DecisionDTO decisionDTO) {
        Decision decision = convertToEntity(decisionDTO);
        Decision createdDecision = decisionRepository.save(decision);
        return convertToDTO(createdDecision);
    }

    public DecisionDTO getDecision(String id) {
        Decision decision = decisionRepository.findById(id).orElse(null);
        return convertToDTO(decision);
    }

    public List<DecisionDTO> getAllDecisions() {
        List<Decision> decisions = decisionRepository.findAll();
        return decisions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DecisionDTO updateDecision(String id, DecisionDTO decisionDTO) {
        if (decisionRepository.existsById(id)) {
            Decision decision = convertToEntity(decisionDTO);
            decision.setId(id);
            Decision updatedDecision = decisionRepository.save(decision);
            return convertToDTO(updatedDecision);
        }
        return null;
    }

    public void deleteDecision(String id) {
        decisionRepository.deleteById(id);
    }

    private DecisionDTO convertToDTO(Decision decision) {
        if (decision == null) return null;
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
