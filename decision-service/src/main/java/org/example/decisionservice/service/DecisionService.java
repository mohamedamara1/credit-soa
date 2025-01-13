package org.example.decisionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.decisionservice.repository.DecisionRepository;
import org.example.decisionservice.model.Decision;

import java.util.List;

@Service
public class DecisionService {

    @Autowired
    private DecisionRepository decisionRepository;

    public Decision createDecision(Decision decision) {
        return decisionRepository.save(decision);
    }

    public Decision getDecision(String id) {
        return decisionRepository.findById(id).orElse(null);
    }

    public List<Decision> getAllDecisions() {
        return decisionRepository.findAll();
    }

    public Decision updateDecision(String id, Decision decision) {
        if (decisionRepository.existsById(id)) {
            decision.setId(id);
            return decisionRepository.save(decision);
        }
        return null;
    }

    public void deleteDecision(String id) {
        decisionRepository.deleteById(id);
    }
}
