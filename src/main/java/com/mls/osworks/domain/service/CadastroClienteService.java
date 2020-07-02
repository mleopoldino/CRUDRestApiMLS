package com.mls.osworks.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mls.osworks.domain.exception.NegocioException;
import com.mls.osworks.domain.model.Cliente;
import com.mls.osworks.domain.repository.ClienteRepository;


@Service
public class CadastroClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		
		Cliente clienteExiste = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExiste != null && clienteExiste.equals(cliente)) {
			
			throw new NegocioException("Já existe um cliente cadastrado com esse endereço de e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}

}
