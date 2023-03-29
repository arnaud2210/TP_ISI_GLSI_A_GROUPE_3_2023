package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.api;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.AccountService;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> listAccounts() {
        return accountService.getAllAccount();
    }

    @PostMapping("/accounts")
    public Account saveAccount(Account account) {
        return accountService.saveAccount(account);
    }


    @GetMapping("/accounts/{accountNumber}")
    public Account showAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountService.findAccountInfo(accountNumber);
    }

    @DeleteMapping("/accounts/{accountNumber}")
    public void removeAccount(@PathVariable String accountNumber) {
        accountService.removeAccount(accountNumber);
    }


}
