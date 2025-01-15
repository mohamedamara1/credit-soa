package org.example.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.clientservice.dto.ClientDTO;
@Builder
public class ClientResponse {

        private String message;
        private ClientDTO clientDTO;
        public ClientResponse() {

        }
        public ClientResponse(String message, ClientDTO clientDTO) {
                this.message = message;
                this.clientDTO = clientDTO;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public ClientDTO getClientDTO() {
                return clientDTO;
        }

        public void setClientDTO(ClientDTO clientDTO) {
                this.clientDTO = clientDTO;
        }
}
