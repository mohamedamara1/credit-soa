package com.bmn.scoredecisionservice.controllers;

import com.bmn.scoredecisionservice.model.Score;
import com.bmn.scoredecisionservice.payload.Request.CreditScoreRequest;
import com.bmn.scoredecisionservice.service.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreControllers {
    private final ScoreService scoreService;

    public ScoreControllers(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping( "/calculate")
    public ResponseEntity<Score> calculateScore(@RequestBody CreditScoreRequest scoreRequest) {
        Score score = scoreService.calculateScore(scoreRequest);
        return ResponseEntity.ok(score);
    }

    @GetMapping("/allscores")
    public ResponseEntity<Iterable<Score>> getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{dossierReference}")
    public ResponseEntity<Score> getScoreByDossierReference(@PathVariable Long dossierReference) {
        try {
            Score score = scoreService.getScoreByDossierReference(dossierReference);
            return ResponseEntity.ok(score);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }


}
