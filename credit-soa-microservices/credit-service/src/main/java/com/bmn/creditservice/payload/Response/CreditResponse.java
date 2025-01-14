package com.bmn.creditservice.payload.Response;


import com.bmn.creditservice.CreditDTO.CreditDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditResponse {
    private String message;
    private CreditDTO credit;
}
