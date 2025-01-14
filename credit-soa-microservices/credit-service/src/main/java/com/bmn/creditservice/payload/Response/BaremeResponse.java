package com.bmn.creditservice.payload.Response;


public class BaremeResponse {

    private Long id;
    private double tauxNominal;
    private int dureeMinimale;
    private int dureeMaximale;
    private double montantMinimal;
    private double montantMaximal;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTauxNominal() {
        return tauxNominal;
    }

    public void setTauxNominal(double tauxNominal) {
        this.tauxNominal = tauxNominal;
    }

    public int getDureeMinimale() {
        return dureeMinimale;
    }

    public void setDureeMinimale(int dureeMinimale) {
        this.dureeMinimale = dureeMinimale;
    }

    public int getDureeMaximale() {
        return dureeMaximale;
    }

    public void setDureeMaximale(int dureeMaximale) {
        this.dureeMaximale = dureeMaximale;
    }

    public double getMontantMinimal() {
        return montantMinimal;
    }

    public void setMontantMinimal(double montantMinimal) {
        this.montantMinimal = montantMinimal;
    }

    public double getMontantMaximal() {
        return montantMaximal;
    }

    public void setMontantMaximal(double montantMaximal) {
        this.montantMaximal = montantMaximal;
    }
}
