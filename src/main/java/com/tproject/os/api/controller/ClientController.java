package com.tproject.os.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tproject.os.domain.model.Client;

@RestController
public class ClientController {	
	
	@GetMapping("/clientes")
	public List<Client> listar() {
		var client1 = new Client(1L,"João", "jao@gmail.com", "51 99855-2819");
		
		var client2 = new Client();
		client2.setId(2L);
		client2.setName("Maria");
		client2.setTelefone("11 98388-2519");
		client2.setEmail("donamaria@gmail.com");
		
		return Arrays.asList(client1, client2);
		
	}

}
