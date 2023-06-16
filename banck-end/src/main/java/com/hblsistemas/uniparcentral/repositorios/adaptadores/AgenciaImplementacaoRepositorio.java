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

import com.hblsistemas.uniparcentral.entidades.Agencia;
import com.hblsistemas.uniparcentral.repositorios.portas.AgenciaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;

@Component
@Primary
public class AgenciaImplementacaoRepositorio implements AgenciaPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Agencia inserir(Agencia agencia) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO agencia (id, codigo, digito, razaosocial, cnpj, ra, banco_id) " + 
					"VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, agencia.getId());
			st.setString(2, agencia.getCodigo());
			st.setString(3, agencia.getDigito());
			st.setString(4, agencia.getRazaoSocial());
			st.setString(5, agencia.getCnpj());
			st.setString(6, agencia.getRegistroAluno());
			st.setLong(7, agencia.getBanco().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					agencia = instanciaAgencia(rs);
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
		return agencia;
	}

	@Override
	public List<Agencia> acharTodos() {
		List<Agencia> agencias = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM agencia");
			while (rs.next()) {
				agencias.add(instanciaAgencia(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return agencias;
	}
	
	@Override
	public Agencia acharPorId(Long id) {
		Agencia agencia = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM agencia " + 
					"WHERE agencia.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				agencia = instanciaAgencia(rs);
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao("Erro! Causado por: " + e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return agencia;
	}

	@Override
	public void atualizar(Agencia agencia, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE agencia " + 
					"SET nome = ?, ra = ? " +
					"WHERE agencia.id = ?");
			st.setString(1, agencia.getRazaoSocial());
			st.setString(2, agencia.getRegistroAluno());
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
			st = conn.prepareStatement("DELETE FROM agencia WHERE agencia.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Agencia instanciaAgencia(ResultSet rs) throws SQLException {
		Agencia agencia = new Agencia(
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null, 
				null);
		return agencia;
	}
}
