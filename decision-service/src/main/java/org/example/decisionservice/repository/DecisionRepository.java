package org.example.decisionservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.example.decisionservice.model.Decision;

public interface DecisionRepository extends JpaRepository<Decision, String> {
}

