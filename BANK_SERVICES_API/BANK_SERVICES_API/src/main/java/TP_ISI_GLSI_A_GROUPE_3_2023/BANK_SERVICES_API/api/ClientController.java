package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.api;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> listClients() {
        return clientService.getAllClient();
    }

    @GetMapping("/clients/{id}")
    public Client showClientById(@PathVariable("id") long id) throws Exception {
        return clientService.findOneClient(id);
    }
    @GetMapping("/clients/{id}/accounts")
    public List<Account> getAllAccountOfTheClient(@PathVariable("id") Long id){
        return clientService.getAllClientAccounts(id);
    }
    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PatchMapping("/clients/{id}")
    public Client updateClient(@PathVariable("id") Long id, @RequestBody Map<String,Object> fields) throws Exception {
        return clientService.updateClient(id,fields);
    }
    @DeleteMapping("/clients/{id}")
    public void removeClient(@PathVariable long id) {
        clientService.removeClient(id);
    }




}
