package TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API;

import TP_ISI_GLSI_A_GROUPE_3_2023.BANK_SERVICES_API.DTO.AccountDTO;
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
			clientRepository.save(
					new Client(
							null,
							"BAGNA",
							"Tarik",
							LocalDate.of(2003,06,12),
							Sexe.MASCULIN,
							"Adidogomé",
							"70433738",
							"tarikbagnapro@gmail.com",
							"Togolaise")
			);
			clientRepository.save(
					new Client(
							null,
							"BAGNA",
							"Khaled",
							LocalDate.of(2002,1,12),
							Sexe.MASCULIN,
							"Tokoin",
							"72366696",
							"khaledbagnapro@gmail.com",
							"Togolaise")
			);
			accountService.saveAccount(
					new AccountDTO(
							null,
							TypeCompte.COURANT,
							LocalDate.now(),
							0.0,
							1L
					)
			);
			accountService.saveAccount(
					new AccountDTO(
							null,
							TypeCompte.COURANT,
							LocalDate.now(),
							0.0,
							2L
					)
			);
		};
	}
}