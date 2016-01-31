package br.com.xy.pois.bo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.xy.pois.POIs;
import br.com.xy.pois.repositorio.Repositorio;

public class POIsBO {

	@Inject
	private Repositorio repositorio;
	
	private static String INSERT = "INSERT INTO XY_POIS VALUES (? , ?, ?)";
	private static String SELECT = "SELECT * FROM XY_POIS";
	private static int TIMEOUT = 30;

	public List<POIs> listarPOIs() throws SQLException {

		List<POIs> lista = new ArrayList<POIs>();
		try {
			PreparedStatement stmt = repositorio.getConnection().prepareStatement(SELECT);
			stmt.setQueryTimeout(TIMEOUT);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				POIs pois = new POIs(rs.getString("NOME"), rs.getInt("X"), rs.getInt("Y"));
				lista.add(pois);
			}
		} catch (SQLException e) {
			throw e;
		}

		return lista;
	}

	public POIs inserirPOIs(int x, int y, String nome) throws SQLException {

		try {
			PreparedStatement stmt = repositorio.getConnection().prepareStatement(INSERT);
			stmt.setQueryTimeout(TIMEOUT);
			stmt.setString(1, nome);
			stmt.setInt(2, x);
			stmt.setInt(3, y);
			stmt.executeUpdate();

			return new POIs(nome, x, y);
		} catch (SQLException e) {
			throw e;
		}
	}

}
