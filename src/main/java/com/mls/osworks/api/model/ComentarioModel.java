package com.mls.osworks.api.model;

import java.time.OffsetDateTime;

public class ComentarioModel {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public OffsetDateTime getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(OffsetDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	public ComentarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComentarioModel(Long id, String descricao, OffsetDateTime dataEnvio) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataEnvio = dataEnvio;
	}
	
	
	
	

}
