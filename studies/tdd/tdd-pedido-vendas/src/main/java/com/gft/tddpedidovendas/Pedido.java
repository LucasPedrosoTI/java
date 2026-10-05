package com.gft.tddpedidovendas;

import java.util.ArrayList;
import java.util.List;

import com.gft.tddpedidovendas.desconto.CalculadoraFaixaDesconto;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<>();

	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;

	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}

	private void validarQuantidade(ItemPedido itemPedido) {
		if (itemPedido.getQuantidade() < 0) {
			throw new QuantidadeItensInvalidaException();
		}
	}

	public void adicionarItem(ItemPedido itemPedido) {
		validarQuantidade(itemPedido);
		itens.add(itemPedido);
	}


	public ResumoPedido resumo() {
		double valorTotal = itens.stream()
				.mapToDouble(item -> item.getValorUnitario() * item.getQuantidade())
				.sum();

		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);

		return new ResumoPedido(valorTotal, desconto);

	}

	public List<ItemPedido> getItens() {
		return itens;
	}

}
