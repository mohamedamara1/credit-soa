package org.example.scoringservice.controller;

import org.example.scoringservice.dto.ScoreDTO;
import org.example.scoringservice.service.ScoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoringController {

    @Autowired
    private ScoringService scoringService;

    @PostMapping
    public ScoreDTO createScore(@RequestBody ScoreDTO scoreDTO) {
        return scoringService.createScore(scoreDTO);
    }

    @GetMapping("/{id}")
    public ScoreDTO getScore(@PathVariable String id) {
        return scoringService.getScore(id);
    }

    @GetMapping
    public List<ScoreDTO> getAllScores() {
        return scoringService.getAllScores();
    }

    @PutMapping("/{id}")
    public ScoreDTO updateScore(@PathVariable String id, @RequestBody ScoreDTO scoreDTO) {
        return scoringService.updateScore(id, scoreDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteScore(@PathVariable String id) {
        scoringService.deleteScore(id);
    }
}
