package br.com.werison.collabctrl.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.werison.collabctrl.entities.Login;
import br.com.werison.collabctrl.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository repository;

	/* SELECT */
	public Iterable<Login> findAll() {
		return repository.findAll();
	}

	public Optional<Login> findById(long id) {
		return repository.findById(id);
	}

	/* DELETE/INSERT/UPDATE */
	public void delete(int id) {
		this.findById(id).ifPresent(item -> {
			// item.setExclusionDate(LocalDateTime.now());
			repository.delete(item);
		});
	}
	
	public Login save(Login item) {
		if (item.getId() > 0) {
			// item.setUpdateDate(LocalDateTime.now());
		}
		return repository.save(item);
	}
}
