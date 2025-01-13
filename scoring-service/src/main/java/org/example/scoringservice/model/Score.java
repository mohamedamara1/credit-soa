package org.example.scoringservice.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {

    @Id
    private String id;
    private String creditId;
    private int score;
    private String evaluation;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
// Getters and Setters
}
