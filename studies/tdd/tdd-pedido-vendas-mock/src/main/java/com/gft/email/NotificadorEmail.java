package com.gft.email;

import com.gft.model.Pedido;
import com.gft.service.AcaoLancamentoPedido;

public class NotificadorEmail implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando o e-mail..." + pedido);
	}
}
