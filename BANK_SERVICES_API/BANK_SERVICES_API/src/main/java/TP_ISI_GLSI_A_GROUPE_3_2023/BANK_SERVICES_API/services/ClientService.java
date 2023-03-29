package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client findOneClient(Long id) {
        return clientRepository.findById(id).get();
    }

    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }
}