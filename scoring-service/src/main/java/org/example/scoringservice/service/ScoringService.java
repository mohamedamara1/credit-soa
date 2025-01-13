package org.example.scoringservice.service;

import org.example.scoringservice.dto.ScoreDTO;
import org.example.scoringservice.model.Score;
import org.example.scoringservice.repository.ScoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoringService {

    @Autowired
    private ScoringRepository scoringRepository;

    public ScoreDTO createScore(ScoreDTO scoreDTO) {
        Score score = convertToEntity(scoreDTO);
        Score createdScore = scoringRepository.save(score);
        return convertToDTO(createdScore);
    }

    public ScoreDTO getScore(String id) {
        Score score = scoringRepository.findById(id).orElse(null);
        return convertToDTO(score);
    }

    public List<ScoreDTO> getAllScores() {
        List<Score> scores = scoringRepository.findAll();
        return scores.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ScoreDTO updateScore(String id, ScoreDTO scoreDTO) {
        if (scoringRepository.existsById(id)) {
            Score score = convertToEntity(scoreDTO);
            score.setId(id);
            Score updatedScore = scoringRepository.save(score);
            return convertToDTO(updatedScore);
        }
        return null;
    }

    public void deleteScore(String id) {
        scoringRepository.deleteById(id);
    }

    private ScoreDTO convertToDTO(Score score) {
        if (score == null) return null;
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
