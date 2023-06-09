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

import com.hblsistemas.uniparcentral.entidades.Banco;
import com.hblsistemas.uniparcentral.repositorios.portas.BancoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;

@Component
@Primary
public class BancoImplementacaoRepositorio implements BancoPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Banco inserir(Banco banco) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement("INSERT INTO banco (id, nome, ra) VALUES (?, ?, ?)");
			st.setLong(1, banco.getId());
			st.setString(2, banco.getNome());
			st.setString(3, banco.getRegistroAluno());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					banco = instanciaBanco(rs);
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
		return banco;
	}

	@Override
	public List<Banco> acharTodos() {
		List<Banco> bancos = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM banco");
			while (rs.next()) {
				bancos.add(instanciaBanco(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return bancos;
	}
	
	@Override
	public Banco acharPorId(Long id) {
		Banco banco = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement("SELECT * FROM banco WHERE banco.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				banco = instanciaBanco(rs);
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao("Erro! Causado por: " + e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return banco;
	}

	@Override
	public void atualizar(Banco banco, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE banco " + 
					"SET nome = ?, ra = ? " +
					"WHERE banco.id = ?");
			st.setString(1, banco.getNome());
			st.setString(2, banco.getRegistroAluno());
			st.setLong(3, banco.getId());
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
			st = conn.prepareStatement("DELETE FROM banco WHERE banco.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Banco instanciaBanco(ResultSet rs) throws SQLException {
		Banco banco = new Banco();
		banco.setId(rs.getLong("id"));
		banco.setNome(rs.getString("nome"));
		banco.setRegistroAluno(rs.getString("ra"));
		return banco;
	}
}
