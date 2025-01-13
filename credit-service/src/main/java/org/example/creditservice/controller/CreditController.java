package org.example.creditservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.creditservice.service.CreditService;
import org.example.creditservice.dto.CreditDTO;
import org.example.creditservice.model.Credit;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    public CreditDTO createCredit(@RequestBody CreditDTO creditDTO) {
        Credit credit = convertToEntity(creditDTO);
        Credit createdCredit = creditService.createCredit(credit);
        return convertToDTO(createdCredit);
    }

    @GetMapping("/{id}")
    public CreditDTO getCredit(@PathVariable String id) {
        Credit credit = creditService.getCredit(id);
        return convertToDTO(credit);
    }

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        List<Credit> credits = creditService.getAllCredits();
        return credits.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public CreditDTO updateCredit(@PathVariable String id, @RequestBody CreditDTO creditDTO) {
        Credit credit = convertToEntity(creditDTO);
        Credit updatedCredit = creditService.updateCredit(id, credit);
        return convertToDTO(updatedCredit);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable String id) {
        creditService.deleteCredit(id);
    }

    private CreditDTO convertToDTO(Credit credit) {
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
