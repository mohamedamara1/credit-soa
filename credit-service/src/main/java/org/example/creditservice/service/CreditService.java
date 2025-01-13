package org.example.creditservice.service;

import org.example.creditservice.dto.CreditDTO;
import org.example.creditservice.model.Credit;
import org.example.creditservice.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    public CreditDTO createCredit(CreditDTO creditDTO) {
        Credit credit = convertToEntity(creditDTO);
        Credit createdCredit = creditRepository.save(credit);
        return convertToDTO(createdCredit);
    }

    public CreditDTO getCredit(String id) {
        Credit credit = creditRepository.findById(id).orElse(null);
        return convertToDTO(credit);
    }

    public List<CreditDTO> getAllCredits() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public CreditDTO updateCredit(String id, CreditDTO creditDTO) {
        if (creditRepository.existsById(id)) {
            Credit credit = convertToEntity(creditDTO);
            credit.setId(id);
            Credit updatedCredit = creditRepository.save(credit);
            return convertToDTO(updatedCredit);
        }
        return null;
    }

    public void deleteCredit(String id) {
        creditRepository.deleteById(id);
    }

    private CreditDTO convertToDTO(Credit credit) {
        if (credit == null) return null;
        CreditDTO creditDTO = new CreditDTO();
        creditDTO.setId(credit.getId());
        creditDTO.setClientId(credit.getClientId());
        creditDTO.setAmount(credit.getAmount());
        creditDTO.setRateId(credit.getRateId());
        creditDTO.setInterest(credit.getInterest());
        creditDTO.setDuration(credit.getDuration());
        creditDTO.setMonthlyPayment(credit.getMonthlyPayment());
        return creditDTO;
    }

    private Credit convertToEntity(CreditDTO creditDTO) {
        Credit credit = new Credit();
        credit.setId(creditDTO.getId());
        credit.setClientId(creditDTO.getClientId());
        credit.setAmount(creditDTO.getAmount());
        credit.setRateId(creditDTO.getRateId());
        credit.setInterest(creditDTO.getInterest());
        credit.setDuration(creditDTO.getDuration());
        credit.setMonthlyPayment(creditDTO.getMonthlyPayment());
        return credit;
    }
}
