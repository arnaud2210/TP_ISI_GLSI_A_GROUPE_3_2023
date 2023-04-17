package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransferDTO {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Long senderIdClient;
    private Long receiverIdClient;
    private Double amount;
}
