package com.mls.osworks.api.model;

import javax.validation.constraints.NotNull;

public class ClientIdInput {
	
	@NotNull
	private Long id;

	public ClientIdInput(Long id) {
		super();
		this.id = id;
	}

	public ClientIdInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
