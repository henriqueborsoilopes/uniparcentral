package com.hblsistemas.uniparcentral.dtos.requests;

import java.time.Instant;

public abstract class PessoaRequest {
	
	private Long id;
	private String email;
	private String registroAluno;
	private Instant dataCadastro;
}
