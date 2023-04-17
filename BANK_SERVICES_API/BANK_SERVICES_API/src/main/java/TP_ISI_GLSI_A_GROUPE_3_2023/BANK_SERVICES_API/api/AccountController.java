package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.api;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.DTO.AccountDTO;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.DTO.AccountTransferDTO;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> listAccounts() {
        return accountService.getAllAccount();
    }

    @GetMapping("/accounts/{accountNumber}")
    public Account showAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber) throws Exception {
        return accountService.findAccountInfo(accountNumber);
    }

    @PostMapping("/accounts")
    public Account saveAccount(@RequestBody AccountDTO account) throws Exception {
        return accountService.saveAccount(account);
    }

    @PostMapping("/accounts/makeADeposit")
    public Account makeADeposit(@RequestBody AccountDTO accountDTO) throws Exception {
        return accountService.makeADeposit(accountDTO);
    }
    @PostMapping("/accounts/withdrawMoney")
    public Account withdrawMoney(@RequestBody AccountDTO accountDTO) throws Exception {
        return accountService.withdrawMoney(accountDTO);
    }
    @PostMapping("/accounts/makeATransfer")
    public Account makeATransfer(@RequestBody AccountTransferDTO accountTransferDTO) throws Exception {
        return accountService.makeATransfer(accountTransferDTO);
    }

    @DeleteMapping("/accounts/{accountNumber}")
    public void removeAccount(@PathVariable String accountNumber) {
        accountService.removeAccount(accountNumber);
    }


}
