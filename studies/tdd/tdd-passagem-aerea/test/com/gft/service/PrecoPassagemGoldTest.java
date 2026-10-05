package com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gft.model.Voo;

public class PrecoPassagemGoldTest {

	PrecoPassagemGold preco;

	@Before
	public void setup() throws Exception {
		preco = new PrecoPassagemGold();
	}

	private void assertPrecoPassagem(double precoVoo, double descontoEsperado) {
		double desconto = preco.calcular(new Voo("origem", "destino", precoVoo));
		assertEquals(descontoEsperado, desconto, 0.0001);
	}

	@Test
	public void deveCalcularPrecoPassagemGoldAbaixoDoLimite() throws Exception {
		assertPrecoPassagem(400.0, 360.0);
	}


	@Test
	public void deveCalcularPrecoPassagemGoldAcimaDoLimite() throws Exception {
		assertPrecoPassagem(1000.0, 850.0);
	}
}
