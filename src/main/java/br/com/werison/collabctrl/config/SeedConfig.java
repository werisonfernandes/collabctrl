package br.com.werison.collabctrl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import br.com.werison.collabctrl.entities.User;
import br.com.werison.collabctrl.repository.UserRepository;

@Configuration
public class SeedConfig implements ApplicationRunner {

	@Autowired
	private UserRepository collaboratorRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Add Collaborator
		User user = new User();
		user.setName("Werison Fernandes");
		user.setEmail("waparecf@everis.com");
		user.setPassword("123456");
		user.setActive(true);

		collaboratorRepo.save(user);
	}

}
