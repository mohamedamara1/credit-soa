package com.bmn.decisionservice.repository;

import com.bmn.decisionservice.model.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DecisionRepository extends JpaRepository<Decision, Long> {
}
