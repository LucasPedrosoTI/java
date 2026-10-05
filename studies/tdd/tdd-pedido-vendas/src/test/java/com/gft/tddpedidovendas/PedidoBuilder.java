package com.gft.tddpedidovendas;

import com.gft.tddpedidovendas.desconto.CalculadoraDesconto1aFaixa;
import com.gft.tddpedidovendas.desconto.CalculadoraDesconto2aFaixa;
import com.gft.tddpedidovendas.desconto.CalculadoraDesconto3aFaixa;
import com.gft.tddpedidovendas.desconto.CalculadoraFaixaDesconto;
import com.gft.tddpedidovendas.desconto.SemDesconto;

public class PedidoBuilder {

	private Pedido instancia;

	public PedidoBuilder() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = new CalculadoraDesconto3aFaixa(
				new CalculadoraDesconto2aFaixa(
						new CalculadoraDesconto1aFaixa(
								new SemDesconto(null))));

		instancia = new Pedido(calculadoraFaixaDesconto);
	}

	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}

	public Pedido construir() {
		return instancia;
	}

}
