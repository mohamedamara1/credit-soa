package com.bmn.scoredecisionservice.service;

import com.bmn.scoredecisionservice.model.Score;
import com.bmn.scoredecisionservice.model.ScoreEvaluation;
import com.bmn.scoredecisionservice.payload.Request.CreditScoreRequest;
import com.bmn.scoredecisionservice.repository.ScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final WebClient webClient;
    public ScoreService(ScoreRepository scoreRepository, WebClient webClient) {
        this.scoreRepository = scoreRepository;
        this.webClient = webClient;
    }

    public boolean isClientBlacklisted(String cin) {
        Boolean result =  webClient.get().uri("http://localhost:8081/clients/isblacklisted/"+cin)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        return result;

    }

    public Score calculateScore(CreditScoreRequest scoreRequest) {
        System.out.println(scoreRequest);
        int score = 0;
        if (isClientBlacklisted(scoreRequest.getCin())) {
            return new Score(scoreRequest.getDossierReference(), score, ScoreEvaluation.ROUGE);
        } else if (scoreRequest.getSalary() > 2000) {
            score += 20;
        } else if (scoreRequest.getSalary() > 1000 && scoreRequest.getSalary() <= 2000) {
            score += 10;
        }

        if ("CDI".equalsIgnoreCase(scoreRequest.getContractType())) {
            score += 30;
        }

        if (scoreRequest.getMensualite() / scoreRequest.getSalary() < 0.45) {
            score += 50;
        }

        ScoreEvaluation evaluation = ScoreEvaluation.fromScore(score);

        Score scoreResult = new Score();
        scoreResult.setDossierReference(scoreRequest.getDossierReference());
        scoreResult.setScore(score);
        scoreResult.setEvaluation(evaluation);

        return scoreResult;


    }

    public Score getScoreByDossierReference(Long dossierReference) {
        Optional<Score> optionalScore = scoreRepository.findByDossierReference(dossierReference);

        if (optionalScore.isEmpty()) {
            throw new IllegalArgumentException("Score not found for dossier reference: " + dossierReference);
        }

        return optionalScore.get();
    }

    public Iterable<Score> getAllScores() {
        return scoreRepository.findAll();
    }
}
