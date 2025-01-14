package com.bmn.scoredecisionservice.repository;

import com.bmn.scoredecisionservice.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
