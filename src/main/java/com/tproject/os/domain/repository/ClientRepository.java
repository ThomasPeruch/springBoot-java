package com.tproject.os.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tproject.os.domain.model.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
	List<Client> findByName(String nome);
	List<Client> findByNameContaining(String nome);
	Client findByEmail(String email);
}
