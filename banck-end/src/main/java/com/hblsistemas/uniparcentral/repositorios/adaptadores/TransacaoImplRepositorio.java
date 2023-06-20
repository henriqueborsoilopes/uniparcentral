package com.hblsistemas.uniparcentral.repositorios.adaptadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.entidades.Transacao;
import com.hblsistemas.uniparcentral.entidades.enums.TipoTransacao;
import com.hblsistemas.uniparcentral.repositorios.portas.TransacaoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.adaptadores.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;

@Component
public class TransacaoImplRepositorio implements TransacaoPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Transacao inserir(Transacao transacao) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO transacao (id, ra, data_hora, valor, tipo, conta_origem, conta_destino) " + 
					"VALUES (?, ?, ?, ?, ?, ?, ?)");
			st.setLong(1, transacao.getId());
			st.setString(2, transacao.getRegistroAluno());
			st.setTimestamp(3, Timestamp.from(transacao.getDataHora()));
			st.setDouble(4, transacao.getValor());
			st.setInt(5, transacao.getTipoTransacao().getCodigo());
			st.setLong(6, transacao.getContaOrigem().getId());
			st.setLong(7, transacao.getContaDestino().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					transacao = instanciaTransacao(rs);
				}
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new BancoDadosExcecao("Transiçao revertida! Causado por: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new BancoDadosExcecao("Erro ao tentar reverter! Causado por: " + e1.getMessage());
			}
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return transacao;
	}

	@Override
	public List<Transacao> acharTodos(Long conta_id) {
		List<Transacao> transacoes = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM transacao" + 
					"INNER JOIN conta co ON co.id = transacao.conta_origem " +
					"INNER JOIN conta cd ON cd.id = transacao.conta_destino " + 
					"WHERE co.id = ?");
			st.setLong(1, conta_id);
			rs = st.executeQuery();
			while (rs.next()) {
				transacoes.add(instanciaTransacao(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return transacoes;
	}
	
	private Transacao instanciaTransacao(ResultSet rs) throws SQLException {
		Conta contaOrigem = new Conta();
		contaOrigem.setId(rs.getLong("conta_origem"));
		Conta contaDestino = new Conta();
		contaDestino.setId(rs.getLong("conta_destino"));
		Transacao transacao = new Transacao(
				rs.getLong("id"), 
				rs.getString("ra"), 
				null, 
				rs.getTimestamp("data_hora").toInstant(), 
				rs.getDouble("valor"), 
				TipoTransacao.paraEnum(rs.getInt("tipo")), 
				contaOrigem, 
				contaDestino);
		return transacao;
	}
}
