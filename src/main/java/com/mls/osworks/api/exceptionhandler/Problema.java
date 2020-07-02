package com.mls.osworks.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

//import com.fasterxml.jackson.annotation.JsonInclude;


//@JsonInclude(Include.NON_NULL)
public class Problema {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<Campo> campo;
	

	public static class Campo{

		private String nome;
		private String mensagem;
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getMensagem() {
			return mensagem;
		}
		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}
		public Campo(String nome, String mensagem) {
			super();
			this.nome = nome;
			this.mensagem = mensagem;
		}
		public Campo() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}
	
	
	

	public Problema() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Problema(Integer status, OffsetDateTime dataHora, String titulo, List<Campo> campo) {
		super();
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
		this.campo = campo;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(OffsetDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Campo> getCampo() {
		return campo;
	}
	public void setCampo(List<Campo> campo) {
		this.campo = campo;
	}
	
	@Override
	public String toString() {
		return "Problema [status=" + status + ", dataHora=" + dataHora + ", titulo=" + titulo + "]";
	}
	
	

}
