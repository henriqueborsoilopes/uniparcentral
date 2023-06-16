package com.hblsistemas.uniparcentral.controladores.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hblsistemas.uniparcentral.servicos.excecoes.ArquivoNaoEncontradoExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ObjetoNaoEncontradoExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ValidacaoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControladorManipuladorExcecao {
	
	@ExceptionHandler(ValidacaoExcecao.class)
	public ResponseEntity<ErroPadrao> validacaoErro(ValidacaoExcecao e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao();
		err.setMomento(Instant.now());
		err.setStatus(status.value());
		err.setErro("Erro de validação");
		err.setMensagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BancoDadosExcecao.class)
	public ResponseEntity<ErroPadrao> bancoDadosErro(BancoDadosExcecao e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao();
		err.setMomento(Instant.now());
		err.setStatus(status.value());
		err.setErro("Erro de banco de dados");
		err.setMensagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ArquivoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> arquivoNaoEncontrado(ArquivoNaoEncontradoExcecao e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao();
		err.setMomento(Instant.now());
		err.setStatus(status.value());
		err.setErro("Erro de arquivo");
		err.setMensagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ObjetoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ObjetoNaoEncontradoExcecao e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao();
		err.setMomento(Instant.now());
		err.setStatus(status.value());
		err.setErro("Erro de objeto");
		err.setMensagem(e.getMessage());
		err.setCaminho(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
