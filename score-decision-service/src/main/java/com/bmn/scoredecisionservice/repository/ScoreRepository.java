package com.bmn.scoredecisionservice.repository;

import com.bmn.scoredecisionservice.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    Optional<Score> findByDossierReference(Long dossierReference);
}
