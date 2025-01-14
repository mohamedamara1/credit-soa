package com.bmn.scoredecisionservice.service;

import com.bmn.scoredecisionservice.model.Score;
import com.bmn.scoredecisionservice.model.ScoreEvaluation;
import com.bmn.scoredecisionservice.payload.Request.CreditScoreRequest;
import com.bmn.scoredecisionservice.repository.ScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final WebClient webClient;
    public ScoreService(ScoreRepository scoreRepository, WebClient webClient) {
        this.scoreRepository = scoreRepository;
        this.webClient = webClient;
    }

    public boolean isClientBlacklisted(String cin) {
        Boolean result =  webClient.get().uri("http://localhost:8081/isblacklisted/{cin}", cin)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        return result;

    }

    public Score calculateScore(CreditScoreRequest request) {
        int score = 0;
        if (isClientBlacklisted(request.getCin())) {
            return new Score(request.getDossierReference(), score, ScoreEvaluation.ROUGE);
        } else return new Score(request.getDossierReference(), score, ScoreEvaluation.ROUGE);


    }


}
