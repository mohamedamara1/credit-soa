package com.bmn.creditservice.controller;

import com.bmn.creditservice.CreditDTO.CreditDTO;
import com.bmn.creditservice.model.Credit;
import com.bmn.creditservice.payload.Request.CreditRequest;
import com.bmn.creditservice.payload.Response.CreditResponse;
import com.bmn.creditservice.service.CreditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditResponse createCredit(@RequestBody CreditRequest credit) {
        CreditDTO creditDTO = creditService.createCredit(credit);
        CreditResponse creditResponse = new CreditResponse("Credit created successfully ",creditDTO);
        return creditResponse;
    }
}
