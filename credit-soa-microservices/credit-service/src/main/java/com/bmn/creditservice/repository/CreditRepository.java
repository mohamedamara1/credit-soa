package com.bmn.creditservice.repository;

import com.bmn.creditservice.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
