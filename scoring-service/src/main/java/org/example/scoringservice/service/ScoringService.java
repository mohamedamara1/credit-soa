package org.example.scoringservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.scoringservice.repository.ScoringRepository;
import org.example.scoringservice.model.Score;

import java.util.List;

@Service
public class ScoringService {

    @Autowired
    private ScoringRepository scoringRepository;

    public Score createScore(Score score) {
        return scoringRepository.save(score);
    }

    public Score getScore(String id) {
        return scoringRepository.findById(id).orElse(null);
    }

    public List<Score> getAllScores() {
        return scoringRepository.findAll();
    }

    public Score updateScore(String id, Score score) {
        if (scoringRepository.existsById(id)) {
            score.setId(id);
            return scoringRepository.save(score);
        }
        return null;
    }

    public void deleteScore(String id) {
        scoringRepository.deleteById(id);
    }
}
