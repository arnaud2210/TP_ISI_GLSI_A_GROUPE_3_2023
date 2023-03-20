package TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.repositories;

import TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
