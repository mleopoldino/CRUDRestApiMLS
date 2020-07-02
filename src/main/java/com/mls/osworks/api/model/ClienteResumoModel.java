package com.mls.osworks.api.model;

public class ClienteResumoModel {
	
	private Long id;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ClienteResumoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClienteResumoModel(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	

}
