package com.gft.service;

import java.util.List;

import com.gft.model.Pedido;
import com.gft.model.StatusPedido;
import com.gft.repository.Pedidos;

public class PedidoService {

	private List<AcaoLancamentoPedido> acoes;
	private Pedidos pedidos;

	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
		this.acoes = acoes;
		this.pedidos = pedidos;
	}

	public double lancar(Pedido pedido) {
		acoes.forEach(acao -> acao.executar(pedido));
		return pedido.getValor() * 0.1;
	}

	public Pedido pagar(Long id) {
		Pedido pedido = pedidos.buscarPeloId(id);

		if (!pedido.getStatus().equals(StatusPedido.PENDENTE)) {
			throw new StatusPedidoInvalidoException();
		}

		pedido.setStatus(StatusPedido.PAGO);

		return pedido;
	}

}
