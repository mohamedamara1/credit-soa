package org.example.creditservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.creditservice.repository.CreditRepository;
import org.example.creditservice.model.Credit;

import java.util.List;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public Credit createCredit(Credit credit) {
        return creditRepository.save(credit);
    }

    public Credit getCredit(String id) {
        return creditRepository.findById(id).orElse(null);
    }

    public List<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    public Credit updateCredit(String id, Credit credit) {
        if (creditRepository.existsById(id)) {
            credit.setId(id);
            return creditRepository.save(credit);
        }
        return null;
    }

    public void deleteCredit(String id) {
        creditRepository.deleteById(id);
    }
}
