package TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.repositories;

import TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
