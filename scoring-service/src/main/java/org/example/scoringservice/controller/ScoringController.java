package org.example.scoringservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.scoringservice.service.ScoringService;
import org.example.scoringservice.dto.ScoreDTO;
import org.example.scoringservice.model.Score;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scores")
public class ScoringController {

    @Autowired
    private ScoringService scoringService;

    @PostMapping
    public ScoreDTO createScore(@RequestBody ScoreDTO scoreDTO) {
        Score score = convertToEntity(scoreDTO);
        Score createdScore = scoringService.createScore(score);
        return convertToDTO(createdScore);
    }

    @GetMapping("/{id}")
    public ScoreDTO getScore(@PathVariable String id) {
        Score score = scoringService.getScore(id);
        return convertToDTO(score);
    }

    @GetMapping
    public List<ScoreDTO> getAllScores() {
        List<Score> scores = scoringService.getAllScores();
        return scores.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ScoreDTO updateScore(@PathVariable String id, @RequestBody ScoreDTO scoreDTO) {
        Score score = convertToEntity(scoreDTO);
        Score updatedScore = scoringService.updateScore(id, score);
        return convertToDTO(updatedScore);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable String id) {
        scoringService.deleteScore(id);
    }

    private ScoreDTO convertToDTO(Score score) {
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setId(score.getId());
        scoreDTO.setCreditId(score.getCreditId());
        scoreDTO.setScore(score.getScore());
        scoreDTO.setEvaluation(score.getEvaluation());
        return scoreDTO;
    }

    private Score convertToEntity(ScoreDTO scoreDTO) {
        Score score = new Score();
        score.setId(scoreDTO.getId());
        score.setCreditId(scoreDTO.getCreditId());
        score.setScore(scoreDTO.getScore());
        score.setEvaluation(scoreDTO.getEvaluation());
        return score;
    }
}

