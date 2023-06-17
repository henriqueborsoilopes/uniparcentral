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
import com.hblsistemas.uniparcentral.entidades.Endereco;
import com.hblsistemas.uniparcentral.entidades.PessoaFisica;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.repositorios.portas.EnderecoPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.ObjetoNaoEncontradoExcecao;

@Component
@Primary
public class EnderecoImplementacaoRepositorio implements EnderecoPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Endereco inserir(Endereco endereco) {	
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO endereco (id, logradouro, numero, bairro, cep, complemento, ra, pessoa_id, cidade_id) " + 
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			st.setLong(1, endereco.getId());
			st.setString(2, endereco.getLogradouro());
			st.setString(2, endereco.getNumero());
			st.setString(2, endereco.getBairro());
			st.setString(2, endereco.getCep());
			st.setString(2, endereco.getComplemento());
			st.setString(2, endereco.getRegistroAluno());
			st.setLong(8, endereco.getMorador().getId());
			st.setLong(9, endereco.getCidade().getId());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					endereco = instanciaEndereco(rs);
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
		return endereco;
	}

	@Override
	public List<Endereco> acharTodos() {
		List<Endereco> enderecos = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM endereco");
			while (rs.next()) {
				enderecos.add(instanciaEndereco(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return enderecos;
	}
	
	@Override
	public Endereco acharPorId(Long id) {
		Endereco endereco = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM endereco " + 
					"WHERE endereco.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				endereco = instanciaEndereco(rs);
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
		return endereco;
	}

	@Override
	public void atualizar(Endereco endereco, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"UPDATE endereco " + 
					"SET logradouro = ?, numero = ?, bairro = ?, cep = ?, complemento = ?, ra = ? " +
					"WHERE endereco.id = ?");
			st.setString(1, endereco.getLogradouro());
			st.setString(2, endereco.getNumero());
			st.setString(3, endereco.getBairro());
			st.setString(4, endereco.getCep());
			st.setString(5, endereco.getComplemento());
			st.setString(6, endereco.getRegistroAluno());
			st.setLong(7, id);
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
					"FROM endereco " + 
					"WHERE endereco.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Endereco instanciaEndereco(ResultSet rs) throws SQLException {
		Pessoa morador = new PessoaFisica();
		Cidade cidade = new Cidade();
		morador.setId(rs.getLong("pessoa_id"));
		cidade.setId(rs.getLong("cidade_id"));
		Endereco endereco = new Endereco( 
				rs.getLong("id"),	
				rs.getString("ra"), 
				null, 
				rs.getString("logradouro"), 
				rs.getString("numero"), 
				rs.getString("bairro"), 
				rs.getString("cep"), 
				rs.getString("complemento"), 
				cidade, 
				morador);
		return endereco;
	}
}
