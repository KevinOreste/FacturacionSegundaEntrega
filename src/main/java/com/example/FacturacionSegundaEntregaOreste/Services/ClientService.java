package com.example.FacturacionSegundaEntregaOreste.Services;

import com.example.FacturacionSegundaEntregaOreste.DTO.ClientDTO;
import com.example.FacturacionSegundaEntregaOreste.Models.Client;
import com.example.FacturacionSegundaEntregaOreste.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public Client createClient(ClientDTO clientDTO){
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setBirthDate(clientDTO.getBirthDate());
        return clientRepository.save(client);
    }

    public Client modifyClient(ClientDTO clientDTO, int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            throw new Exception();
        }
        client.get().setName(clientDTO.getName());
        client.get().setLastName(clientDTO.getLastName());
        client.get().setBirthDate(clientDTO.getBirthDate());
        return clientRepository.save(client.get());
    }

    public void deleteClient(int id) throws Exception {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            throw new Exception();
        }
        clientRepository.delete(client.get());
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

}
