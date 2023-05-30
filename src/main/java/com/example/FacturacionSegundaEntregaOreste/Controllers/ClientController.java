package com.example.FacturacionSegundaEntregaOreste.Controllers;


import com.example.FacturacionSegundaEntregaOreste.DTO.ClientDTO;
import com.example.FacturacionSegundaEntregaOreste.Models.Client;
import com.example.FacturacionSegundaEntregaOreste.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping (path = "/")
    public String createClient(@RequestBody ClientDTO client){
        clientService.createClient(client);
        return "se creo el cliente";
    }

    @DeleteMapping (path = "/{id}")
        public String deleteClient (@PathVariable int id){

        try{
            clientService.deleteClient(id);
            return "se borro el usuario";
        }catch (Exception e){
            return "ocurrio un error al borrar el usuario";
        }

    }

    @GetMapping (path = "/")
    public List<Client> getClients (){
        return clientService.getClients();
    }

    @PutMapping (path = "/{id}")
    public String modifyClient(@RequestBody ClientDTO clientDTO, @PathVariable int id){
        try {
        clientService.modifyClient(clientDTO, id);
        return "se modifico el usuario";
        }catch (Exception e){
            return "no se encontro el usuario";
        }

    }

}
