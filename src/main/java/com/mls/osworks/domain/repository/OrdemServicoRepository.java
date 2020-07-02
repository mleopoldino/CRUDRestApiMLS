package com.mls.osworks.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mls.osworks.domain.model.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository <OrdemServico, Long> {

	
	
}
