package org.example.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.clientservice.model.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByCin(String cin);
}