package com.tproject.os.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tproject.os.domain.model.OrderService;


@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Long>{

}
