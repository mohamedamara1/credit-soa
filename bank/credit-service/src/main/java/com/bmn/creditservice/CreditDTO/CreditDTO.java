package com.bmn.creditservice.CreditDTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditDTO {
    private Long id;

    private String clientCin;
    private double montant;
    private Long baremeId;
    private double interet;
    private int duree;
    private double mensualite;

}
