package com.hblsistemas.uniparcentral.repositorios.adaptadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.entidades.PessoaFisica;
import com.hblsistemas.uniparcentral.entidades.PessoaJuridica;
import com.hblsistemas.uniparcentral.entidades.abstratas.Pessoa;
import com.hblsistemas.uniparcentral.repositorios.portas.PessoaPortaRepositorio;
import com.hblsistemas.uniparcentral.servicos.JdbcConexao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;

@Component
@Primary
public class PessoaImplementacaoRepositorio implements PessoaPortaRepositorio {
	
	private Connection conn = null;
	
	@Override
	public Pessoa inserir(Pessoa pessoa) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO pessoa (email, ra) " + 
					"VALUES (?, ?)");
			st.setString(1, pessoa.getEmail());
			st.setString(2, pessoa.getRegistroAluno());
			int rowsAffected = st.executeUpdate();
			conn.commit();
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next()) {
					pessoa.setId(rs.getLong("id"));
					if (pessoa instanceof PessoaFisica fisica) {
						pessoa = inserirPessoaFisica(fisica);
					} else if (pessoa instanceof PessoaJuridica juridica) {
						pessoa = inserirPessoaJuridica(juridica);
					}
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
		return pessoa;
	}
	
	@Override
	public List<Pessoa> acharTodos() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.addAll(acharTodosPessoasFisicas());
		pessoas.addAll(acharTodosPessoasJuridicas());
		return pessoas;
	}
	
	@Override
	public Pessoa acharPorId(Long id) {
		Pessoa pessoa = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.prepareStatement(
					"SELECT * " + 
					"FROM pessoa " + 
					"INNER JOIN pessoafisica ON pessoafisica.pessoa_id = pessoa.id " +
					"WHERE pessoa.id = ?");
			st.setLong(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				pessoa = instanciaPessoaFisica(rs);
			} else {
				JdbcConexao.fecharStatment(st);
				JdbcConexao.fecharResultSet(rs);
				st = conn.prepareStatement(
					"SELECT * " + 
					"FROM pessoa " + 
					"INNER JOIN pessoajuridica ON pessoajuridica.pessoa_id = pessoa.id" +
					"WHERE pessoa.id = ?");
				st.setLong(1, id);
				rs = st.executeQuery();
				if (rs.next()) {
					pessoa = instanciaPessoaJuridica(rs);
				}
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao("Erro! Causado por: " + e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return pessoa;
	}

	@Override
	public void atualizar(Pessoa pessoa, Long id) {
		PreparedStatement st = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			if (pessoa instanceof PessoaFisica pf) {
				st = conn.prepareStatement(
						"UPDATE pessoa " + 
						"SET " +
						"WHERE pessoa.id = ?");
			} else if (pessoa instanceof PessoaFisica pf) {
				st = conn.prepareStatement(
						"UPDATE pessoa " + 
						"SET " +
						"WHERE pessoa.id = ?");
			}
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
					"FROM pessoa " + 
					"WHERE pessoa.id = ?");
			st.setLong(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
	}
	
	private Pessoa inserirPessoaFisica(PessoaFisica pf) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO pessoafisica (nome, cpf, rg, datanascimento, pessoa_id) " + 
					"VALUES (?, ?, ?, ?, ?)");
			st.setString(1, pf.getNome());
			st.setString(2, pf.getCpf());
			st.setString(3, pf.getRg());
			st.setTimestamp(4, Timestamp.valueOf(pf.getDataNascimento()));
			st.setLong(5, pf.getId());
			st.executeUpdate();
			conn.commit();
			
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
		return pf;
	}
	
	private Pessoa inserirPessoaJuridica(PessoaJuridica pj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(
					"INSERT INTO pessoajuridica (razaosocial, cnpj, cnaeprincipal, nomefantasia, pessoa_id) " + 
					"VALUES (?, ?, ?, ?, ?)");
			st.setString(1, pj.getRazaoSocial());
			st.setString(2, pj.getCnpj());
			st.setString(3, pj.getCnaePrincipal());
			st.setString(4, pj.getNomeFantasia());
			st.setLong(5, pj.getId());
			st.executeUpdate();
			conn.commit();
			
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
		return pj;
	}
	
	private List<Pessoa> acharTodosPessoasFisicas() {
		List<Pessoa> pessoas = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM pessoa " + 
					"INNER JOIN pessoafisica ON pessoafisica.pessoa_id = pessoa.id");
			while (rs.next()) {
				pessoas.add(instanciaPessoaFisica(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return pessoas;
	}
	
	private List<Pessoa> acharTodosPessoasJuridicas() {
		List<Pessoa> pessoas = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcConexao.getConexao();
			st = conn.createStatement();
			rs = st.executeQuery(
					"SELECT * " + 
					"FROM pessoa " + 
					"INNER JOIN pessoajuridica ON pessoajuridica.pessoa_id = pessoa.id");
			while (rs.next()) {
				pessoas.add(instanciaPessoaJuridica(rs));
			}
		} catch (SQLException e) {
			throw new BancoDadosExcecao(e.getMessage());
		} finally {
			JdbcConexao.fecharResultSet(rs);
			JdbcConexao.fecharStatment(st);
			JdbcConexao.fecharConexao();
		}
		return pessoas;
	}
	
	private Pessoa instanciaPessoaFisica(ResultSet rs) throws SQLException {
		Pessoa pessoa = new PessoaFisica(
				rs.getLong("id"),
				rs.getString("email"), 
				rs.getString("ra"), 
				rs.getTimestamp("datacadastro").toInstant(), 
				rs.getString("nome"), 
				rs.getString("cpf"), 
				rs.getString("rg"), 
				rs.getTimestamp("datanascimento").toLocalDateTime());
		return pessoa;
	}
	
	private Pessoa instanciaPessoaJuridica(ResultSet rs) throws SQLException {
		Pessoa pessoa = new PessoaJuridica(
				rs.getLong("id"),
				rs.getString("email"), 
				rs.getString("ra"), 
				rs.getTimestamp("datacadastro").toInstant(), 
				rs.getString("razaosocial"), 
				rs.getString("cnpj"), 
				rs.getString("cnaeprincipal"), 
				rs.getString("fantasia"));
		return pessoa;
	}
}
