package org.example.clientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.clientservice.model.Client;
public interface ClientRepository extends JpaRepository<Client, String> {

}