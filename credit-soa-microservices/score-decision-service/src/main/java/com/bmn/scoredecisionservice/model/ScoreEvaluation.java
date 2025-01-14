package com.bmn.scoredecisionservice.model;

public enum ScoreEvaluation {
    VERT ,
    ROUGE;

    public static ScoreEvaluation fromScore(int score) {
        if (score < 50) {
            return ROUGE;
        } else {
            return VERT;}
    }
}
