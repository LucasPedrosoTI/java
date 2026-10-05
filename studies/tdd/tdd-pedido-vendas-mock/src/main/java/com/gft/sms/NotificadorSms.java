package com.gft.sms;

import com.gft.model.Pedido;
import com.gft.service.AcaoLancamentoPedido;

public class NotificadorSms implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando o sms..." + pedido);

	}
}
