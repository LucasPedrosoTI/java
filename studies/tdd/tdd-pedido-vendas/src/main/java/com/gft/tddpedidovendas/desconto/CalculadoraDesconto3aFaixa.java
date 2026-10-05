package com.gft.tddpedidovendas.desconto;

public class CalculadoraDesconto3aFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDesconto3aFaixa(
			CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return valorTotal > 1000 ? valorTotal * 0.08 : -1;
	}

}
