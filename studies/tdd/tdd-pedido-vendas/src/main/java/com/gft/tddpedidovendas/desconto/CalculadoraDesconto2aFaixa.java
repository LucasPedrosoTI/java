package com.gft.tddpedidovendas.desconto;

public class CalculadoraDesconto2aFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDesconto2aFaixa(
			CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return valorTotal > 800 && valorTotal <= 1000 ? valorTotal * 0.06 : -1;
	}

}
