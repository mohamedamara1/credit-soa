package com.bmn.creditservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientCin;
    private double montant;
    private Long baremeId;
    private double interet;
    private int duree;
    private double mensualite;

    public Credit(Long id, String clientCin, double montant, Long baremeId, double interet, int duree, double mensualite) {
        this.id = id;
        this.clientCin = clientCin;
        this.montant = montant;
        this.baremeId = baremeId;
        this.interet = interet;
        this.duree = duree;
        this.mensualite = mensualite;
    }

    public Credit() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientCin() {
        return clientCin;
    }

    public void setClientCin(String clientCin) {
        this.clientCin = clientCin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Long getBaremeId() {
        return baremeId;
    }

    public void setBaremeId(Long baremeId) {
        this.baremeId = baremeId;
    }

    public double getInteret() {
        return interet;
    }

    public void setInteret(double interet) {
        this.interet = interet;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
    }
}
