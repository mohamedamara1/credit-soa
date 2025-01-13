package org.example.creditservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.example.creditservice.model.Credit;

public interface CreditRepository extends JpaRepository<Credit, String> {
}
