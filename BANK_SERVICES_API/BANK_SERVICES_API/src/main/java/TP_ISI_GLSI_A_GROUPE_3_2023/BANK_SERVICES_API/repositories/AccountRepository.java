package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,String> {
    @Query("SELECT a FROM Account a WHERE a.owner.id=:idClient")
    List<Account> findAllByClientId(@Param("idClient") Long idClient);
}
