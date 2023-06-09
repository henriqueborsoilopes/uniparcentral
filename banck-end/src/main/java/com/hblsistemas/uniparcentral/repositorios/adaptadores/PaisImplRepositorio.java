package com.hblsistemas.uniparcentral.repositorios.adaptadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.entidades.Pais;
import com.hblsistemas.uniparcentral.repositorios.portas.PaisPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.adaptadores.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ObjetoNaoEncontradoExcecao;

@Component
public class PaisImplRepositorio implements PaisPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Pais inserir(Pais pais) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO pais (id, nome, abreviacao, ra) " + 
					"VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, pais.getId());
			st.setString(2, pais.getNome());
			st.setString(3, pais.getSigla());
			st.setString(4, pais.getRegistroAluno());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					pais = instanciaPais(rs);
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
		return pais;
	}

	@Override
	public List<Pais> acharTodos() {
		List<Pais> paises = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM pais");
			while (rs.next()) {
				paises.add(instanciaPais(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return paises;
	}
	
	@Override
	public Pais acharPorId(Long id) {
		Pais pais = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM pais " + 
					"WHERE pais.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				pais = instanciaPais(rs);
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
		return pais;
	}

	@Override
	public void atualizar(Pais pais, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE pais " + 
					"SET nome = ?, abreviacao = ?, ra = ? " +
					"WHERE pais.id = ?");
			st.setString(1, pais.getNome());
			st.setString(2, pais.getSigla());
			st.setString(3, pais.getRegistroAluno());
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
					"FROM pais " + 
					"WHERE pais.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Pais instanciaPais(ResultSet rs) throws SQLException {
		Pais pais = new Pais();
		pais.setId(rs.getLong("id"));
		pais.setNome(rs.getString("nome"));
		pais.setSigla(rs.getString("abreviacao"));
		pais.setRegistroAluno(rs.getString("ra"));
		return pais;
	}
}
