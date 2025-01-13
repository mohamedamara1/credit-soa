package org.example.scoringservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.example.scoringservice.model.Score;

public interface ScoringRepository extends JpaRepository<Score, String> {
}

