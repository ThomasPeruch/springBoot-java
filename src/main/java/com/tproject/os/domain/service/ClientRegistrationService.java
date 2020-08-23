package com.tproject.os.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tproject.os.domain.exception.CustomException;
import com.tproject.os.domain.model.Client;
import com.tproject.os.domain.repository.ClientRepository;

@Service
public class ClientRegistrationService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client save(Client client) {
		Client existente = clientRepository.findByEmail(client.getEmail());
		if(existente != null && !existente.equals(client)) {
			throw new CustomException("Já existe um cliente cadastrado com este e-mail");	
		}
		return clientRepository.save(client);
	}
	
	public void delete(Long clientId) {
		clientRepository.deleteById(clientId);
	}

}
