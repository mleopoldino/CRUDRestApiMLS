package com.mls.osworks.domain.service;

import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mls.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.mls.osworks.domain.exception.NegocioException;
import com.mls.osworks.domain.model.Cliente;
import com.mls.osworks.domain.model.Comentario;
import com.mls.osworks.domain.model.OrdemServico;
import com.mls.osworks.domain.model.StatusOrdemServico;
import com.mls.osworks.domain.repository.ClienteRepository;
import com.mls.osworks.domain.repository.ComentarioRepository;
import com.mls.osworks.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {

		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não localizado na Base de Dados."));

		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());

		return ordemServicoRepository.save(ordemServico);
	}

	public void finalizar(Long ordemServiçoId) {

		OrdemServico ordemServico = buscar(ordemServiçoId);
		ordemServico.finalizar();

		ordemServicoRepository.save(ordemServico);

	}

	public void cancelar(Long ordemServiçoId) {

		OrdemServico ordemServico = buscar(ordemServiçoId);
		ordemServico.cancelar();

		ordemServicoRepository.save(ordemServico);

	}

	public Comentario adicionarComentario(Long ordemServicoId, String descricao) {

		OrdemServico ordemServico = buscar(ordemServicoId);

		Comentario comentario = new Comentario();

		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricao(descricao);

		comentario.setOrdemServico(ordemServico);

		return comentarioRepository.save(comentario);

	}

	private OrdemServico buscar(Long ordemServicoId) {
		return ordemServicoRepository.findById(ordemServicoId).orElseThrow(
				() -> new EntidadeNaoEncontradaException("Ordem de Serviço não localizada na Base de Dados."));
	}

}
