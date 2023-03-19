package TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.entities;

import TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API.enums.TypeCompte;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(name="numero_compte",nullable = false,length = 5)
    private String accountNumber;
    @Column(name="type_compte",nullable = false)
    private TypeCompte typeCompte;
    @Column(name = "date_de_creation",nullable = false)
    private LocalDate creationDate;
    @Column(name = "solde_compte",nullable = false)
    private Double accountBalance;

    @ManyToOne
    @Column(name = "proprietaire",nullable = false)
    private Client owner;
}
