package org.example.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clientservice.dto.ClientDTO;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponse {

        private String message;
        private ClientDTO clientDTO;
}
