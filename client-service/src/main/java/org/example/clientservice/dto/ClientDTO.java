package org.example.clientservice.dto;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class ClientDTO {

    private String cin;
    private String name;
    private double salary;
    private String contractType;
    private String birthDate;
    private boolean blacklisted;

  }
