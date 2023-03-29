package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.AccountRepository;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClientRepository clientRepository;

    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        //TODO: Generated account number
        account.setAccountNumber(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 5).toUpperCase() + Calendar.getInstance().get(Calendar.YEAR));
        return accountRepository.save(account);
    }

    public Account findAccountInfo(String accountNumber) {
        return accountRepository.findById(accountNumber).get();
    }

    public void removeAccount(String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }

    public Account makeADeposit(Long clientId,String accountNumber,Double amount) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        if(amount<0){
            throw new Exception("The amount is negative");
        }
        checkIfClientExist(clientId, accountNumber, optionalClient, optionalAccount);
        Account account = optionalAccount.get();
        account.setAccountBalance(account.getAccountBalance()+amount);
        Account accountEnd = accountRepository.save(account);
        System.out.println(accountEnd.toString());
        return accountEnd;
    }
    public Account withdrawMoney(Long clientId,String accountNumber,Double amount) throws Exception {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        checkIfClientExist(clientId, accountNumber, optionalClient, optionalAccount);
        Account account = optionalAccount.get();
        if(!withdrawMoneyCheck(account,amount)){
            throw new Exception("The account balance is less than the amount to be withdrawn");
        }
        System.out.println(account.toString());
        return accountRepository.save(account);
    }

    public Account makeATransfer(Long senderClientId,Long receiverClientId,String  senderAccountNumber,String receiverAccountNumber,Double amount) throws Exception {
        Optional<Client> optionalSenderClient = clientRepository.findById(senderClientId);
        Optional<Client> optionalReceiverClient = clientRepository.findById(receiverClientId);
        Optional<Account> optionalSenderAccount = accountRepository.findById(senderAccountNumber);
        Optional<Account> optionalReceiverAccount = accountRepository.findById(receiverAccountNumber);
        checkIfClientExist(senderClientId,senderAccountNumber,optionalSenderClient,optionalSenderAccount);
        checkIfClientExist(receiverClientId,receiverAccountNumber,optionalReceiverClient,optionalReceiverAccount);
        Account senderAccount = optionalSenderAccount.get();
        Account receiverAccount = optionalReceiverAccount.get();

        withdrawMoney(senderAccount.getOwner().getId(), senderAccount.getAccountNumber(),amount);
        makeADeposit(receiverAccount.getOwner().getId(), receiverAccount.getAccountNumber(),amount);

        return senderAccount;
    }
    private void checkIfClientExist(Long clientId, String accountNumber, Optional<Client> optionalClient, Optional<Account> optionalAccount) throws Exception {
        if(optionalClient.isEmpty()){
            throw new Exception("The client with id '"+clientId+"' does not exist");
        }
        if(optionalAccount.isEmpty()){
            throw new Exception("The account with number '"+accountNumber+"' does not exist");
        }

        if(!(optionalClient.get().getId() == optionalAccount.get().getOwner().getId())){
            throw new Exception("The user with the id '"+clientId+"' is not the owner of the account with number '"+accountNumber+"'");
        }
    }

    public boolean withdrawMoneyCheck(Account account,Double amount) {
        if (account.getAccountBalance() >= amount) {
            account.setAccountBalance(account.getAccountBalance()-amount);
            return true;
        }
        return false;
    }
//
//    public boolean transfertMoney(Account senderAccount, Double amount) {
//        if(withDrawMoney(amount)) {
//            senderAccount.depositMoney(amount);
//            return true;
//        }
//        return false;
//    }

}
