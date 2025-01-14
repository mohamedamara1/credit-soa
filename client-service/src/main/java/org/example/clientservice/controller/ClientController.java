package org.example.clientservice.controller;


import lombok.RequiredArgsConstructor;
import org.example.clientservice.model.ClientResponse;
import org.example.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.clientservice.service.ClientService;
import org.example.clientservice.dto.ClientDTO;
import org.example.clientservice.model.Client;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor()
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;


    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ClientResponse> createOrFindClient(@RequestBody Client client) {

            if(clientRepository.findByCin(client.getCin()).isEmpty()){
                ClientDTO clientDTO = clientService.createClient(client);
                ClientResponse response = new ClientResponse("Client created successfully", clientDTO);
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            else return new ResponseEntity<>(new ClientResponse("Client already exists",
                    clientService.getClient(client.getCin())), HttpStatus.OK);

    }

    @GetMapping("/{cin}")
    @ResponseStatus
    public ClientDTO getClient(@PathVariable String cin) {
        return clientService.getClient(cin);
    }



    @PutMapping("/{cin}")
    public ResponseEntity<ClientResponse>  updateClient(@PathVariable String cin, @RequestBody Client client) {
        ClientDTO clientDTO =  clientService.updateClient(cin, client);
        ClientResponse response = new ClientResponse("Client updated successfully", clientDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("isblacklisted/{cin}")
    public boolean isBlacklisted(@PathVariable String cin) {
        return clientService.getClient( cin).isBlacklisted();
    }

    @DeleteMapping("/{cin}")
    public ResponseEntity<?> deleteClient(@PathVariable String cin) {
        clientService.deleteClient(cin);
        return new ResponseEntity<>("Client deleted successfully", HttpStatus.OK);
    }


}
