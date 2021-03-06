package com.tproject.os.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tproject.os.domain.model.Client;
import com.tproject.os.domain.repository.ClientRepository;
import com.tproject.os.domain.service.ClientRegistrationService;

@RestController
@RequestMapping("/clientes")
public class ClientController {	

	@Autowired
	private ClientRegistrationService clientRegistration;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<Client> showClients() {
		return clientRepository.findAll();
		
	}

	@GetMapping("/clientes/{clientId}")
	public ResponseEntity<Client> findClient(@PathVariable long clientId) {
		Optional<Client> client = clientRepository.findById(clientId);
		
		if(client.isPresent()) {
			return ResponseEntity.ok(client.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client addClient(@Valid @RequestBody Client client) {
		return clientRegistration.save(client);
		
	};

	@PutMapping("/{clientId}")
	public ResponseEntity<Client> update(@Valid @PathVariable Long clientId, @RequestBody Client client){
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		client.setId(clientId);
		client = clientRegistration.save(client);
		
		return ResponseEntity.ok(client);
	}
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> delete(@PathVariable Long clientId){
		if(!clientRepository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		
		clientRegistration.delete(clientId);
		return ResponseEntity.noContent().build();
	}
}