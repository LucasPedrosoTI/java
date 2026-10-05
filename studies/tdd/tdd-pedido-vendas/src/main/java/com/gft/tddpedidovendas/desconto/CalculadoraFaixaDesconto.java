package com.gft.tddpedidovendas.desconto;

public abstract class CalculadoraFaixaDesconto {

	private CalculadoraFaixaDesconto proximo;

	public CalculadoraFaixaDesconto(
			CalculadoraFaixaDesconto proximo) {
		this.proximo = proximo;
	}

	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);

		return desconto == -1 ? proximo.desconto(valorTotal) : desconto;
	}

	protected abstract double calcular(double valorTotal);

}
