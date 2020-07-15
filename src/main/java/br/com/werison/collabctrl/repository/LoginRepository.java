package br.com.werison.collabctrl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.werison.collabctrl.entities.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long>{

}
