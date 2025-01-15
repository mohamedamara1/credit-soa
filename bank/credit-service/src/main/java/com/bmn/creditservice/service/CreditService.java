package com.bmn.creditservice.service;

import com.bmn.creditservice.CreditDTO.CreditDTO;
import com.bmn.creditservice.model.Credit;
import com.bmn.creditservice.payload.Response.BaremeResponse;
import com.bmn.creditservice.payload.Request.CreditRequest;
import com.bmn.creditservice.repository.CreditRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CreditService {

    private final CreditRepository creditRepository;
    private final WebClient.Builder webClientBuilder;

    public CreditService(CreditRepository creditRepository, WebClient.Builder webClient) {
        this.creditRepository = creditRepository;
        this.webClientBuilder = webClient;
    }


    public CreditDTO createCredit(CreditRequest creditRequest) {
        String baremeServiceUrl = "http://bareme-service/bareme/" + creditRequest.getBaremeId();
        BaremeResponse bareme = webClientBuilder.build().get()
                .uri(baremeServiceUrl )
                .retrieve()
                .bodyToMono(BaremeResponse.class)
                .block();

        if (bareme == null) {
            throw new IllegalArgumentException("Invalid Bareme ID");
        }

        double interest = creditRequest.getMontant() * bareme.getTauxNominal();
        double mensualite = (creditRequest.getMontant() + interest) / creditRequest.getDuree();

        // Create and save the credit dossier
        Credit credit = new Credit();
        credit.setClientCin(creditRequest.getClientCIN());
        credit.setMontant(creditRequest.getMontant());
        credit.setDuree(creditRequest.getDuree());
        credit.setBaremeId(creditRequest.getBaremeId());
        credit.setInteret(interest);
        credit.setMensualite(mensualite);

        creditRepository.save(credit);
        return mapToCreditDTO(credit);
    }


    private CreditDTO mapToCreditDTO(Credit credit) {
        return CreditDTO.builder()
                .id(credit.getId())
                .clientCin(credit.getClientCin())
                .montant(credit.getMontant())
                .baremeId(credit.getBaremeId())
                .interet(credit.getInteret())
                .duree(credit.getDuree())
                .mensualite(credit.getMensualite())
                .build();
    }
}
