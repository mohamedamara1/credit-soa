package com.bmn.baremeservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bareme {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double tauxNominal;
        private int dureeMinimale;
        private int dureeMaximale;
        private double montantMinimal;
        private double montantMaximal;

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

        public Bareme() {
        }

        public Bareme(Long id, double tauxNominal, int dureeMinimale, int dureeMaximale, double montantMinimal, double montantMaximal) {
                this.id = id;
                this.tauxNominal = tauxNominal;
                this.dureeMinimale = dureeMinimale;
                this.dureeMaximale = dureeMaximale;
                this.montantMinimal = montantMinimal;
                this.montantMaximal = montantMaximal;
        }
}
