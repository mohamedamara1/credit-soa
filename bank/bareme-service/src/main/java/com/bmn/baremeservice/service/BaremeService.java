package com.bmn.baremeservice.service;


import com.bmn.baremeservice.model.Bareme;
import com.bmn.baremeservice.repository.BaremeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BaremeService {
    @Autowired
    private BaremeRepository baremeRepository;

    public Bareme createBareme(Bareme bareme) {
        return baremeRepository.save(bareme);
    }



    public List<Bareme> getAllBaremes() {
        return baremeRepository.findAll();
    }

    public Optional<Bareme> getBaremeById(Long id) {
        return baremeRepository.findById(id);
    }

    public void deleteBareme(Long id) {
        baremeRepository.deleteById(id);
    }

    public Bareme selectBestBareme(double montant, int duree) {
        List<Bareme> matchingBaremes = baremeRepository.findMatchingBaremes(montant, duree);
        if (matchingBaremes.size() == 1) {
            return matchingBaremes.get(0);
        }
        return matchingBaremes.stream()
                .min((bareme1, bareme2) -> Double.compare(bareme1.getTauxNominal(), bareme2.getTauxNominal()))
                .orElse(null);
    }
}
