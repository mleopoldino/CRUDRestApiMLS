package com.mls.osworks.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.mls.osworks.domain.ValidationGroups;
import com.mls.osworks.domain.ValidationGroups.ClienteId;
import com.mls.osworks.domain.exception.NegocioException;


@Entity
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@JsonProperty (access = Access.READ_ONLY)	
	@Enumerated(EnumType.STRING)
	private StatusOrdemServico status;
	
	@JsonProperty (access = Access.READ_ONLY)	
	private OffsetDateTime dataAbertura;
	
	@JsonProperty (access = Access.READ_ONLY)	
	private OffsetDateTime dataFinalizacao;
	
	@OneToMany(mappedBy="ordemServico")
	private List<Comentario> comentario = new ArrayList<>();
	
	public List<Comentario> getComentario() {
		return comentario;
	}
	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public StatusOrdemServico getStatus() {
		return status;
	}
	public void setStatus(StatusOrdemServico status) {
		this.status = status;
	}
	public OffsetDateTime getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(OffsetDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public OffsetDateTime getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(OffsetDateTime dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
		
	public OrdemServico() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public OrdemServico(Long id,
			@Valid @ConvertGroup(from = Default.class, to = ClienteId.class) @NotNull Cliente cliente,
			@NotBlank String descricao, @NotNull BigDecimal preco, StatusOrdemServico status,
			OffsetDateTime dataAbertura, OffsetDateTime dataFinalizacao, List<Comentario> comentario) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.descricao = descricao;
		this.preco = preco;
		this.status = status;
		this.dataAbertura = dataAbertura;
		this.dataFinalizacao = dataFinalizacao;
		this.comentario = comentario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public boolean podeSerFinalizada() {
		return StatusOrdemServico.ABERTA.equals(getStatus());
	}
	
	public boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
	
	public void finalizar() {
		// TODO Auto-generated method stub
		
		if(naoPodeSerFinalizada()) {
			throw new NegocioException("Ordem de serviço não pode ser finalizada.");
		}
		
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
		
		
	}
	public void cancelar() {
		// TODO Auto-generated method stub
		
		
		if(naoPodeSerFinalizada()) {
			throw new NegocioException("Ordem de serviço não pode ser cancelada.");
		}
		
		setStatus(StatusOrdemServico.CANCELADA);
		setDataFinalizacao(OffsetDateTime.now());
		
	}
	
		
	
}
