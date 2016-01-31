package br.com.xy.pois.text;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import br.com.xy.pois.POIs;

public class POIsTest {

	@Test
	public void POIsModelTest() {

		POIs pois = new POIs("Padaria", 15, 20);

		assertEquals("Localizacao X da Padaria deve ser 15!", 15, pois.getX());
		assertEquals("Localizacao Y Padaria deve ser 15!", 20, pois.getY());
		assertEquals("Nome do ponto deve ser 'Pandaria'!", "Padaria", pois.getNome());

	}

	@Test
	public void POIsDistanceTest() throws SQLException {

		POIs pois = new POIs("Padaria", 15, 20);
		POIs poisNear = new POIs("Supermercado", 16, 25);
		int distanceMaxima = 10;

		assertEquals("Localizacao Supermercado nao esta perto da Padaria", true,
				pois.isNear(poisNear.getX(), poisNear.getY(), distanceMaxima));

	}

}
