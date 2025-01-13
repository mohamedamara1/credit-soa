package org.example.clientservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.clientservice.service.ClientService;
import org.example.clientservice.dto.ClientDTO;
import org.example.clientservice.model.Client;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
        Client client = convertToEntity(clientDTO);
        Client createdClient = clientService.createClient(client);
        return convertToDTO(createdClient);
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable String id) {
        Client client = clientService.getClient(id);
        return convertToDTO(client);
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return clients.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable String id, @RequestBody ClientDTO clientDTO) {
        Client client = convertToEntity(clientDTO);
        Client updatedClient = clientService.updateClient(id, client);
        return convertToDTO(updatedClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }

    private ClientDTO convertToDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setCin(client.getCin());
        clientDTO.setSalary(client.getSalary());
        clientDTO.setContractType(client.getContractType());
        clientDTO.setBirthDate(client.getBirthDate());
        return clientDTO;
    }

    private Client convertToEntity(ClientDTO clientDTO) {
        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setCin(clientDTO.getCin());
        client.setSalary(clientDTO.getSalary());
        client.setContractType(clientDTO.getContractType());
        client.setBirthDate(clientDTO.getBirthDate());
        return client;
    }
}
