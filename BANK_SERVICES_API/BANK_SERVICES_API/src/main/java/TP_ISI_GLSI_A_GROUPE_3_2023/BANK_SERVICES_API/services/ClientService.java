package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.enums.Sexe;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.AccountRepository;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public Client findOneClient(Long id) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            return optionalClient.get();
        }
        throw new Exception("The client with the id : "+id+" does not exist");
    }

    public List<Account> getAllClientAccounts(Long idClient){
        return accountRepository.findAllByClientId(idClient);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Map<String,Object> fields) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if(optionalClient.isPresent()){
            fields.forEach((key,value)->{
                Field field = ReflectionUtils.findField(Client.class,key);
                field.setAccessible(true);
                if(field.getName().equals("sexe")){
                    ReflectionUtils.setField(field,optionalClient.get(), Sexe.values()[(int) value]);
                }else if(field.getName().equals("dateOfBirth")){
                    ReflectionUtils.setField(field,optionalClient.get(), LocalDate.parse((CharSequence) value, DateTimeFormatter.ISO_DATE));
                }else {
                    ReflectionUtils.setField(field,optionalClient.get(),value);
                }

            });
            return clientRepository.save(optionalClient.get());
        }
        throw new Exception("The client with the id : "+id+" does not exist");
    }

    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }
}
