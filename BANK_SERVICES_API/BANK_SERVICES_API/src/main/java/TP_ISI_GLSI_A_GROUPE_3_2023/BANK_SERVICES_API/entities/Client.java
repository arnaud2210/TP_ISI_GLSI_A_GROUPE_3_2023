package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.enums.Sexe;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom_du_client",nullable = false)
    private String lastname;
    @Column(name = "prenom_du_client",nullable = false)
    private String firstname;
    @Column(name = "date_de_naissance",nullable = false)
    private Date dateOfBirth;
    @Column(name = "sexe_du_client",nullable = false)
    private Sexe sexe;
    @Column(name = "adresse_du_client")
    private String address;
    @Column(name = "telephone_du_client")
    private String telephone;
    @Column(name = "email_du_client")
    private String email;
    @Column(name = "nationalite_du_client",nullable = false)
    private String nationality;
}
