package com.tproject.os.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tproject.os.domain.exception.CustomException;
import com.tproject.os.domain.model.Client;
import com.tproject.os.domain.model.OrderService;
import com.tproject.os.domain.model.StatusOrderService;
import com.tproject.os.domain.repository.ClientRepository;
import com.tproject.os.domain.repository.OrderServiceRepository;

@Service
public class OrderServiceManagerService {

	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	public OrderService create(OrderService orderService) {
		Client client = clientRepository.findById(orderService.getClient().getId()).
				orElseThrow(()-> new CustomException("Cliente não encontrado"));
		orderService.setClient(client);
		orderService.setStatus(StatusOrderService.OPEN);
		orderService.setOpenDate(OffsetDateTime.now());
		
		return orderServiceRepository.save(orderService);
		
	}
}
