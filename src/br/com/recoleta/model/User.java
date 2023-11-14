package br.com.recoleta.model;

import br.com.recoleta.enums.UserType;

public class User {
	
	private Integer id;
	private String name;
	private String cpf_cnpj;
	private String email;
	private String fone;
	private String password;
	private UserType type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public User(Integer id, String name, String cpf_cnpj, String email, String fone, String password, UserType type) {
		this.id = id;
		this.name = name;
		this.cpf_cnpj = cpf_cnpj;
		this.email = email;
		this.fone = fone;
		this.password = password;
		this.type = type;
	}
	
	public User() {
	}
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getState() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
