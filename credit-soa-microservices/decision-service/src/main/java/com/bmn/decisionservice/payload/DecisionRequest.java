package com.bmn.decisionservice.payload;

public class DecisionRequest {
    private String decision;
    private Long dossierRef;

    public DecisionRequest(String decision, Long dossierRef) {
        this.decision = decision;
        this.dossierRef = dossierRef;
    }
    public DecisionRequest(){

    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Long getDossierRef() {
        return dossierRef;
    }

    public void setDossierRef(Long dossierRef) {
        this.dossierRef = dossierRef;
    }

    @Override
    public String toString() {
        return "DecisionRequest{" +
                "decision='" + decision + '\'' +
                ", dossierRef=" + dossierRef +
                '}';
    }
}
