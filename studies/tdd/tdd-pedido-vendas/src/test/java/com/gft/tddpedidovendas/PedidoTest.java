package com.gft.tddpedidovendas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {

	private PedidoBuilder pedido;

	@Before
	public void setup() {
		pedido = new PedidoBuilder();
	}

	private void assertResumoPedido(Double valorTotal, Double desconto) {
		ResumoPedido resumo = pedido.construir()
				.resumo();

		assertEquals(new ResumoPedido(valorTotal, desconto), resumo);
	}

	@Test
	public void devePermitirAdicionarUmItemNoPedido() throws Exception {
		pedido.comItem(3.0, 10);

		assertEquals(1, pedido.construir()
				.getItens()
				.size());
	}

	@Test
	public void deveCalcularResumoPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoPedidoComItemSemDeconto() throws Exception {
		pedido.comItem(5.0, 5);
		assertResumoPedido(25.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.comItem(3.0, 3);
		pedido.comItem(7.0, 3);

		assertResumoPedido(30.0, 0.0);
	}

	@Test
	public void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.comItem(20.0, 20);

		assertResumoPedido(400.0, 16.0);
	}

	@Test
	public void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.comItem(30.0, 30);

		assertResumoPedido(900.0, 54.0);
	}

	@Test
	public void deveAplicarDescontoNa3aFaixa() throws Exception {
		pedido.comItem(15, 60);
		pedido.comItem(10, 30);

		assertResumoPedido(1200.0, 96.0);
	}
	
	@Test(expected = QuantidadeItensInvalidaException.class)
	public void naoAceitarPedidosComQuantidadesNegativas() throws Exception {
		pedido.comItem(0.0, -10);
	}
}










