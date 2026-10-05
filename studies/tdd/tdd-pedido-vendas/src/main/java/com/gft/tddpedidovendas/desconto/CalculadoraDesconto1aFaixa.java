package com.gft.tddpedidovendas.desconto;

public class CalculadoraDesconto1aFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDesconto1aFaixa(
			CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return valorTotal > 300.0 && valorTotal <= 800.0 ? valorTotal * 0.04 : -1;
	}

}
