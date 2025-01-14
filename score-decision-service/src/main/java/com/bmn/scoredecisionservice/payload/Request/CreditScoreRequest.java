package com.bmn.scoredecisionservice.payload.Request;


public class CreditScoreRequest {
    private Long dossierReference;
    private double salary;
    private String contractType;
    private double mensualite;
    private String cin;

    public Long getDossierReference() {
        return dossierReference;
    }

    public void setDossierReference(Long dossierReference) {
        this.dossierReference = dossierReference;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public CreditScoreRequest(Long dossierReference, double salary, String contractType, double mensualite, String cin) {
        this.dossierReference = dossierReference;
        this.salary = salary;
        this.contractType = contractType;
        this.mensualite = mensualite;
        this.cin = cin;
    }

    public CreditScoreRequest() {

    }
}
