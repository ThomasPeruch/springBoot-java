package com.tproject.os.domain.model;

public class Client {
	private Long id;
	private String name;
	private String email;
	private String telefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Client(Long id, String name, String email, String telefone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Client() {
		super();
	}
	
	
	
	

}
