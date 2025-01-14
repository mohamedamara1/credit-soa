package com.bmn.decisionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Decision {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long dossierReference;
        private LocalDate decisionDate;
        private String statutDecision;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDossierReference() {
        return dossierReference;
    }

    public void setDossierReference(Long dossierReference) {
        this.dossierReference = dossierReference;
    }

    public LocalDate getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(LocalDate decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getStatutDecision() {
        return statutDecision;
    }

    public void setStatutDecision(String statutDecision) {
        this.statutDecision = statutDecision;
    }

    public Decision( Long dossierReference, String statutDecision) {
        this.statutDecision = statutDecision;
        this.decisionDate = LocalDate.now();
        this.dossierReference = dossierReference;
    }

    public Decision() {

    }
}
