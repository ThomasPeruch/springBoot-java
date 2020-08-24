package com.tproject.os.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tproject.os.api.model.OrderServiceModel;
import com.tproject.os.domain.model.OrderService;
import com.tproject.os.domain.repository.OrderServiceRepository;
import com.tproject.os.domain.service.OrderServiceManagerService;

@RestController
@RequestMapping("/ordens-servico")
public class OrderServiceController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrderServiceManagerService manager;
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderService create(@Valid @RequestBody OrderService orderService) {
		return manager.create(orderService);
		
	}
	
	@GetMapping
	public List<OrderService> show(){
		return orderServiceRepository.findAll();
	}
	
	@GetMapping("/{orderServiceId}")
	public ResponseEntity<OrderServiceModel>find(@PathVariable Long orderServiceId){
		Optional<OrderService> orderService =orderServiceRepository.findById(orderServiceId);

		if(orderService.isPresent()) {
			OrderServiceModel model = modelMapper.map(orderService.get(), OrderServiceModel.class);
			return ResponseEntity.ok(model);
		}
		
		return ResponseEntity.notFound().build();
	}

}
