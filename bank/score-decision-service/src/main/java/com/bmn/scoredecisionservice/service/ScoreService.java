package com.bmn.scoredecisionservice.service;

import com.bmn.scoredecisionservice.model.Score;
import com.bmn.scoredecisionservice.model.ScoreEvaluation;
import com.bmn.scoredecisionservice.payload.Request.CreditScoreRequest;
import com.bmn.scoredecisionservice.repository.ScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final WebClient.Builder webClientBuilder;
    public ScoreService(ScoreRepository scoreRepository, WebClient.Builder webClient) {
        this.scoreRepository = scoreRepository;
        this.webClientBuilder = webClient;
    }

    public boolean isClientBlacklisted(String cin) {
        Boolean result =  webClientBuilder.build().get().uri("http://client-service/clients/isblacklisted/"+cin)
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

        scoreRepository.save(scoreResult);
        return scoreResult;


    }

    public Score getScoreByDossierReference(Long dossierReference) {
        Optional<Score> optionalScore = scoreRepository.findByDossierReference(dossierReference);

        if (optionalScore.isEmpty()) {
            throw new IllegalArgumentException("Score not found for dossier reference: " + dossierReference);
        }

        return optionalScore.get();
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }
}
