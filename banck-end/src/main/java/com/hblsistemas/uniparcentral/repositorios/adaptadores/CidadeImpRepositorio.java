package com.hblsistemas.uniparcentral.repositorios.adaptadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.entidades.Cidade;
import com.hblsistemas.uniparcentral.entidades.Estado;
import com.hblsistemas.uniparcentral.repositorios.portas.CidadePortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.adaptadores.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ObjetoNaoEncontradoExcecao;

@Component
@Primary
public class CidadeImpRepositorio implements CidadePortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Cidade inserir(Cidade cidade) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO cidade (id, nome, ra, estado_id) " + 
					"VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, cidade.getId());
			st.setString(2, cidade.getNome());
			st.setString(3, cidade.getRegistroAluno());
			st.setLong(4, cidade.getEstado().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					cidade = instanciaCidade(rs);
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
		return cidade;
	}

	@Override
	public List<Cidade> acharTodos() {
		List<Cidade> cidades = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM cidade");
			while (rs.next()) {
				cidades.add(instanciaCidade(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return cidades;
	}
	
	@Override
	public Cidade acharPorId(Long id) {
		Cidade cidade = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM cidade " + 
					"WHERE cidade.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				cidade = instanciaCidade(rs);
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
		return cidade;
	}

	@Override
	public void atualizar(Cidade cidade, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE cidade " + 
					"SET nome = ?, ra = ? " +
					"WHERE cidade.id = ?");
			st.setString(1, cidade.getNome());
			st.setString(2, cidade.getRegistroAluno());
			st.setLong(3, id);
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
					"FROM cidade " + 
					"WHERE cidade.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Cidade instanciaCidade(ResultSet rs) throws SQLException {
		Estado estado = new Estado();
		estado.setId(rs.getLong("estado_id"));
		Cidade cidade = new Cidade(
				rs.getLong("id"), 
				rs.getString("ra"), 
				null, 
				rs.getString("nome"), 
				estado);
		return cidade;
	}
}
