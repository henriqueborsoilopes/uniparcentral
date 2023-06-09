package com.hblsistemas.uniparcentral.servicos;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.hblsistemas.uniparcentral.servicos.excecoes.ArquivoNaoEncontradoExcecao;
import com.hblsistemas.uniparcentral.servicos.excecoes.BancoDadosExcecao;

@Component
public class JdbcConexao {
	
	private static Connection conn = null;
	
	public static Connection getConexao() {
		if (conn == null) {
			try {
				Properties props = carregarPropriedades();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new BancoDadosExcecao(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void fecharConexao() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				throw new BancoDadosExcecao(e.getMessage());
			}
		}
	}
	
	public static void fecharStatment(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new BancoDadosExcecao(e.getMessage());
			}
		}
	}
	
	public static void fecharResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new BancoDadosExcecao(e.getMessage());
			}
		}
	}
	
	private static Properties carregarPropriedades() {
		try (FileInputStream fs = new FileInputStream("src/main/resources/bancodados.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new ArquivoNaoEncontradoExcecao(e.getMessage());
		}
	}
}
