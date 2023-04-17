package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.DTO;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String accountNumber;
    private TypeCompte typeCompte;
    private LocalDate creationDate;
    private Double accountBalance;
    private Long idClient;
}
