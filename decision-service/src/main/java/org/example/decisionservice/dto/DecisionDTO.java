package org.example.decisionservice.dto;


public class DecisionDTO {
    private String id;
    private String creditId;
    private String decisionDate;
    private String status;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(String decisionDate) {
        this.decisionDate = decisionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
