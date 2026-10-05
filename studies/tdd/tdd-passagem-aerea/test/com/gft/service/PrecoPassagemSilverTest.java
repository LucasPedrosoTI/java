package com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gft.model.Voo;

public class PrecoPassagemSilverTest {

	PrecoPassagemSilver preco;

	@Before
	public void setup() throws Exception {
		preco = new PrecoPassagemSilver();
	}

	private void assertPrecoPassagem(double precoVoo, double descontoEsperado) {
		double desconto = preco.calcular(new Voo("origem", "destino", precoVoo));
		assertEquals(descontoEsperado, desconto, 0.0001);
	}

	@Test
	public void deveCalcularPrecoPassagemSilverAbaixoDoLimite() throws Exception {
		assertPrecoPassagem(400.0, 376.0);
	}


	@Test
	public void deveCalcularPrecoPassagemSilverAcimaDoLimite() throws Exception {
		assertPrecoPassagem(1000.0, 900.0);
	}
}
