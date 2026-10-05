package com.gft.service;

import com.gft.model.Voo;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		return voo.getPreco() > 500 ? voo.getPreco() * 0.85 : voo.getPreco() * 0.9;
	}

}
