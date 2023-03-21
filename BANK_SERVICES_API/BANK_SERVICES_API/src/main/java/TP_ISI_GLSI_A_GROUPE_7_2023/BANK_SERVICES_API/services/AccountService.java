package TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.services;

import TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findAccountInfo(String accountNumber) {
        return accountRepository.findById(accountNumber).get();
    }

    public void removeAccount(String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }

    public void depositMoney(Double amount) {
        this.accountBalance += amount;
    }

    public boolean withDrawMoney(Double amount) {
        if (this.accountBalance >= amount) {
            this.accountBalance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfertMoney(Account senderAccount, Double amount) {
        if(withDrawMoney(amount)) {
            senderAccount.depositMoney(amount);
            return true;
        }
        return false;
    }
}
