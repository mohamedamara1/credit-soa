package com.bmn.baremeservice.repository;


import com.bmn.baremeservice.model.Bareme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaremeRepository extends JpaRepository<Bareme, Long> {
    @Query("SELECT b FROM Bareme b WHERE b.montantMinimal <= :montant " +
            "AND b.montantMaximal >= :montant " +
            "AND b.dureeMinimale <= :duree " +
            "AND b.dureeMaximale >= :duree")
    List<Bareme> findMatchingBaremes(double montant, int duree);
}
