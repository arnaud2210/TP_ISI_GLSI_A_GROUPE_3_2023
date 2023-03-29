package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.api;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.AccountService;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> listClients() {
        return clientService.getAllClient();
    }

    @PostMapping("/clients")
    public Client saveClient(Client client) {
        return clientService.saveClient(client);
    }

    @GetMapping("/clients/{id}")
    public Client showClientById(@PathVariable("id") long id) {
        return clientService.findOneClient(id);
    }

    @DeleteMapping("/clients/{id}")
    public void removeClient(@PathVariable long id) {
        clientService.removeClient(id);
    }




}
