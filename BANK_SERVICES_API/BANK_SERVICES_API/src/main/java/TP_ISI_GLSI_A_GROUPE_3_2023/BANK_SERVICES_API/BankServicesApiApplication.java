package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Account;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.entities.Client;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.enums.Sexe;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.enums.TypeCompte;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.AccountRepository;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.repositories.ClientRepository;
import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class BankServicesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServicesApiApplication.class, args);
	}

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountService accountService;
	@Autowired
	ClientRepository clientRepository;
	@Bean
	CommandLineRunner start(){
		return args -> {
			accountService.saveAccount(
					new Account(
							null,
							TypeCompte.COURANT,
							LocalDate.now(),
							0.0,
							clientRepository.save(
									new Client(
											null,
											"BAGNA",
											"Tarik",
											new Date(2003,06,12),
											Sexe.MASCULIN,
											"Addidogomé",
											"70433738",
											"tarikbagnapro@gmail.com",
											"Togolese")
							)
					)
			);
			accountService.saveAccount(
					new Account(
							null,
							TypeCompte.COURANT,
							LocalDate.now(),
							0.0,
							clientRepository.save(
									new Client(
											null,
											"BAGNA",
											"Khaled",
											new Date(183,1,12),
											Sexe.MASCULIN,
											"Tokoin",
											"72366696",
											"khaledbagnapro@gmail.com",
											"Togolese")
							)
					)
			);
		};
	}
}