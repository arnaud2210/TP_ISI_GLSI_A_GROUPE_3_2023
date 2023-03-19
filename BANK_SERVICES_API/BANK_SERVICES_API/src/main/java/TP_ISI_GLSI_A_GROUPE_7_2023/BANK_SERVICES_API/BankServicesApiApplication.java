package TP_ISI_GLSI_A_GROUPE_7_2023.BANK_SERVICES_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	Client(id,nom,prenom,date_naissance,sexe,adresse,tel,email,nationalite)
	Compte(num_compte,type_compte,date_creation,solde,propriétaire)
	TypeDeCompte (enum){Epargne,Courant}
*/

@SpringBootApplication
public class BankServicesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServicesApiApplication.class, args);
	}

}
