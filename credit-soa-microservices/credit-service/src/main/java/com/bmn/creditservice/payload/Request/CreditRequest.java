package com.bmn.creditservice.payload.Request;


public class CreditRequest {

    private String clientCIN;
    private double montant;
    private int duree;
    private Long baremeId;

    public String getClientCIN() {
        return clientCIN;
    }

    public void setClientCIN(String clientCIN) {
        this.clientCIN = clientCIN;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Long getBaremeId() {
        return baremeId;
    }

    public void setBaremeId(Long baremeId) {
        this.baremeId = baremeId;
    }
}
