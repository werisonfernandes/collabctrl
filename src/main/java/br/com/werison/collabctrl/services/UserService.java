package br.com.werison.collabctrl.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.werison.collabctrl.entities.User;
import br.com.werison.collabctrl.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	/* SELECT */
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	public Optional<User> findById(int id) {
		return repository.findById(id);
	}

	/* DELETE/INSERT/UPDATE */
	public void delete(int id) {
		this.findById(id).ifPresent(item -> {
			//item.setExclusionDate(LocalDateTime.now());
			repository.delete(item);
		});
	}

	public User inactivate(User item) {
		//item.setUpdateDate(LocalDateTime.now());
		//item.setActive(false);
		return repository.save(item);
	}

	public User save(User item) {
		if (item.getId() > 0) {
			//item.setUpdateDate(LocalDateTime.now());
		}
		return repository.save(item);
	}
}
