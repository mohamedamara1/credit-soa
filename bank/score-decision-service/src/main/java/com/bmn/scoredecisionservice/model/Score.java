package com.bmn.scoredecisionservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dossierReference;
    private int score;
    private ScoreEvaluation evaluation;



    public Long getDossierReference() {
        return dossierReference;
    }

    public void setDossierReference(Long dossierReference) {
        this.dossierReference = dossierReference;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ScoreEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(ScoreEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Score{" +
                "dossierReference='" + dossierReference + '\'' +
                ", score=" + score +
                ", evaluation=" + evaluation +
                '}';
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Score(Long id,Long dossierReference, int score, ScoreEvaluation evaluation) {
        this.id = id;
        this.dossierReference = dossierReference;
        this.score = score;
        this.evaluation = evaluation;
    }
    public Score(Long dossierReference, int score, ScoreEvaluation evaluation) {

        this.dossierReference = dossierReference;
        this.score = score;
        this.evaluation = evaluation;
    }
    public Score() {

    }
}
