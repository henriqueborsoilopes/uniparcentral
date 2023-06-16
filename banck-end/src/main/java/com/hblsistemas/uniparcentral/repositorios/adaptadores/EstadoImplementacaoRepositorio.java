package com.hblsistemas.uniparcentral.repositorios.adaptadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.repositorios.portas.EstadoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ObjetoNaoEncontradoExcecao;

@Component
public class EstadoImplementacaoRepositorio implements EstadoPortaRepositorio {
	
	private Connection conn;
	
	@Override
	public Estado inserir(Estado estado) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO estado (id, nome, abreviacao, ra, pais_id) " + 
					"VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, estado.getId());
			st.setString(2, estado.getNome());
			st.setString(3, estado.getSigla());
			st.setString(4, estado.getRegistroAluno());
			st.setLong(5, estado.getPais().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					estado = instanciaEstado(rs);
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
		return estado;
	}

	@Override
	public List<Estado> acharTodos() {
		List<Estado> estados = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM estado");
			while (rs.next()) {
				estados.add(instanciaEstado(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return estados;
	}
	
	@Override
	public Estado acharPorId(Long id) {
		Estado estado = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM estado " + 
					"WHERE estado.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				estado = instanciaEstado(rs);
			} else {
				throw new ObjetoNaoEncontradoExcecao("Object não encontrado. Id: " + id);
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao("Erro! Causado por: " + e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return estado;
	}

	@Override
	public void atualizar(Estado estado, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE estado " + 
					"SET nome = ?, abreviacao = ?, ra = ? " +
					"WHERE estado.id = ?");
			st.setString(1, estado.getNome());
			st.setString(2, estado.getSigla());
			st.setString(3, estado.getRegistroAluno());
			st.setLong(4, id);
			st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new BancoDadosExcecao("Transiçao revertida! Causado por: " + e.getMessage());
			} catch (SQLException e1) {
				throw new BancoDadosExcecao("Erro ao tentar reverter! Causado por: " + e1.getMessage());
			}
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}

	@Override
	public void deletar(Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
						"DELETE " + 
						"FROM estado " + 
						"WHERE estado.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Estado instanciaEstado(ResultSet rs) throws SQLException {
		Pais pais = new Pais();
		pais.setId(rs.getLong("pais_id"));
		Estado estado = new Estado(
				rs.getLong("id"), 
				rs.getString("nome"), 
				null, 
				rs.getString("abreviacao"), 
				rs.getString("ra"),
				pais
				);
		return estado;
	}
}
