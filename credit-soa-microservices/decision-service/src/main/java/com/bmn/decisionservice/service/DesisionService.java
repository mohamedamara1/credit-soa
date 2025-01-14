package com.bmn.decisionservice.service;

import com.bmn.decisionservice.model.Decision;
import com.bmn.decisionservice.repository.DecisionRepository;
import org.springframework.stereotype.Service;

@Service
public class DesisionService {

    private final DecisionRepository decisionRepository;

    public DesisionService(DecisionRepository decisionRepository) {
        this.decisionRepository = decisionRepository;
    }

    public Decision makeDecision(Long dossierReference, String score) {
        String statutDecision = score == "rouge" ? "Refus" : "Acceptation";
        Decision decision = new Decision(dossierReference, statutDecision);
        return decisionRepository.save(decision);
    }
}
