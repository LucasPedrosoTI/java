package com.gft.service;

import com.gft.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		return voo.getPreco() > 700 ? voo.getPreco() * 0.9 : voo.getPreco() * 0.94;
	}

}
