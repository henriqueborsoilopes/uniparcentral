package com.hblsistemas.uniparcentral.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.servicos.PaisServico;

@RestController
@RequestMapping("/paises")
public class PaisControlador {
	
	private PaisServico paisServico;
	
	public PaisControlador(PaisServico paisServico) {
		this.paisServico = paisServico;
	}
	
	@GetMapping
	public void acharPorId() {
		Pais pais = paisServico.acharPorId(1058L);
		System.out.println(pais.getNome());
	}
}
