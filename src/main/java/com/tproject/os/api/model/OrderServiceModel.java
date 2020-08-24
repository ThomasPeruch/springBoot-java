package com.tproject.os.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.tproject.os.domain.model.StatusOrderService;

public class OrderServiceModel {
	
	private Long id;
	private String nameClient;
	private String description;
	private BigDecimal price;
	private StatusOrderService status;
	private OffsetDateTime openDate;
	private OffsetDateTime finishDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public StatusOrderService getStatus() {
		return status;
	}
	public void setStatus(StatusOrderService status) {
		this.status = status;
	}
	public OffsetDateTime getOpenDate() {
		return openDate;
	}
	public void setOpenDate(OffsetDateTime openDate) {
		this.openDate = openDate;
	}
	public OffsetDateTime getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(OffsetDateTime finishDate) {
		this.finishDate = finishDate;
	}
	
	

}
