package br.com.xy.pois.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Repositorio {

	private Connection conn;

	private static String sDriverName = "org.sqlite.JDBC";

	private static String sTempDb = "xy.db";
	private static String sJdbc = "jdbc:sqlite";
	private static String sDbUrl = sJdbc + ":" + sTempDb;
	private static String CREATE = "CREATE TABLE IF NOT EXISTS XY_POIS (NOME TEXT, X NUMERIC, Y NUMERIC)";

	@PostConstruct
	private void abrirConexao() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(sDriverName);
			this.conn =  DriverManager.getConnection(sDbUrl);
			verificarSchema();
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}

	@PreDestroy
	private void fecharConexao() throws SQLException {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}

	public Connection getConnection() {
		return this.conn;
	}
	
	private void verificarSchema() throws SQLException {

		try {
			PreparedStatement stmt = getConnection().prepareStatement(CREATE);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
	}

}