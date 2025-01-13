package org.example.creditservice.controller;

import org.example.creditservice.dto.CreditDTO;
import org.example.creditservice.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    public CreditDTO createCredit(@RequestBody CreditDTO creditDTO) {
        return creditService.createCredit(creditDTO);
    }

    @GetMapping("/{id}")
    public CreditDTO getCredit(@PathVariable String id) {
        return creditService.getCredit(id);
    }

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getAllCredits();
    }

    @PutMapping("/{id}")
    public CreditDTO updateCredit(@PathVariable String id, @RequestBody CreditDTO creditDTO) {
        return creditService.updateCredit(id, creditDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCredit(@PathVariable String id) {
        creditService.deleteCredit(id);
    }
}
