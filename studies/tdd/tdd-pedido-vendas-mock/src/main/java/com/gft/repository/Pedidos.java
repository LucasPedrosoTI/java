package com.gft.repository;

import com.gft.model.Pedido;
import com.gft.service.AcaoLancamentoPedido;

public class Pedidos implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados..." + pedido);
	}

	public Pedido buscarPeloId(Long id) {
		return Pedido.builder().build();
	}
}
