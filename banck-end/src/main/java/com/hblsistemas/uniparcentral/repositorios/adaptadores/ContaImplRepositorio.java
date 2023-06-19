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
import com.hblsistemas.uniparcentral.entidades.Conta;
import com.hblsistemas.uniparcentral.entidades.PessoaFisica;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.entidades.enums.TipoConta;
import com.hblsistemas.uniparcentral.repositorios.portas.ContaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.adaptadores.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ObjetoNaoEncontradoExcecao;

@Component
@Primary
public class ContaImplRepositorio implements ContaPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Conta inserir(Conta conta) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO conta (numero, digito, saldo, tipo, ra, agencia_id, pessoa_id) " + 
					"VALUES (?, ?, ?, ?, ?, ?, ?)");
			st.setString(1, conta.getNumero());
			st.setString(2, conta.getDigito());
			st.setDouble(3, conta.getSaldo());
			st.setInt(4, conta.getTipoConta().getCodigo());
			st.setString(5, conta.getRegistroAluno());
			st.setLong(6, conta.getAgencia().getId());
			st.setLong(7, conta.getTitular().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					conta = instanciaConta(rs);
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
		return conta;
	}

	@Override
	public List<Conta> acharTodos() {
		List<Conta> contas = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM conta");
			while (rs.next()) {
				contas.add(instanciaConta(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return contas;
	}
	
	@Override
	public Conta acharPorId(Long id) {
		Conta conta = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM conta " + 
					"WHERE conta.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				conta = instanciaConta(rs);
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
		return conta;
	}

	@Override
	public void atualizarSaldo(Double saldo, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE conta " + 
					"SET saldo = ?" +
					"WHERE conta.id = ?");
			st.setDouble(1, saldo);
			st.setLong(2, id);
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
					"FROM conta " + 
					"WHERE conta.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Conta instanciaConta(ResultSet rs) throws SQLException {
		Pessoa pessoa = new PessoaFisica();
		pessoa.setId(rs.getLong("pessoa_id"));
		Agencia agencia = new Agencia();
		agencia.setId(rs.getLong("agencia_id"));
		Conta conta = new Conta(
				rs.getLong("id"), 
				rs.getString("ra"), 
				null, 
				rs.getString("numero"), 
				rs.getString("digito"), 
				rs.getDouble("saldo"), 
				TipoConta.paraEnum(rs.getInt("tipo")), 
				agencia, 
				pessoa);
		return conta;
	}
}
