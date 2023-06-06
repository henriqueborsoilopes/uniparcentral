package com.hblsistemas.uniparcentral.servicos;

import org.springframework.stereotype.Service;

import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.repositorios.portas.PaisRepositorioPorta;

@Service
public class PaisServico {
	
	private PaisRepositorioPorta paisRepositorioPorta;
	
	public PaisServico(PaisRepositorioPorta paisRepositorioPorta) {
		this.paisRepositorioPorta = paisRepositorioPorta;
	}
	
	public Pais acharPorId(Long id) {
		return paisRepositorioPorta.acharPorId(id);
	}
}
