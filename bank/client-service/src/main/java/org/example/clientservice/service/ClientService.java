package org.example.clientservice.service;


import lombok.RequiredArgsConstructor;
import org.example.clientservice.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.example.clientservice.repository.ClientRepository;
import org.example.clientservice.model.Client;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientDTO createClient(Client client) {

        clientRepository.save(client);
        return mapToClientDTO(client);
    }

    public ClientDTO getClient(String cin)  {
        Optional<Client> clientOptional = clientRepository.findByCin(cin);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return mapToClientDTO(client);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client with CIN " + cin + " not found.");
        }
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::mapToClientDTO).toList();
    }

    public ClientDTO updateClient(String cin, Client clientDetails) {
        Optional<Client> clientOptional = clientRepository.findByCin(cin);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(clientDetails.getName());
            client.setSalary(clientDetails.getSalary());
            client.setContractType(clientDetails.getContractType());
            client.setBirthDate(clientDetails.getBirthDate());
            clientRepository.save(client);
            return mapToClientDTO(client);
        }
        return null;
    }



    public void deleteClient(String id) {
        clientRepository.deleteById(id);
    }




    private ClientDTO mapToClientDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setCin(client.getCin());
        clientDTO.setName(client.getName());
        clientDTO.setSalary(client.getSalary());
        clientDTO.setContractType(client.getContractType());
        clientDTO.setBirthDate(client.getBirthDate());
        clientDTO.setBlacklisted(client.isBlacklisted());
        return clientDTO;
    }


}

