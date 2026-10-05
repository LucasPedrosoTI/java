package com.gft.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.gft.email.NotificadorEmail;
import com.gft.model.Pedido;
import com.gft.model.StatusPedido;
import com.gft.repository.Pedidos;
import com.gft.sms.NotificadorSms;

class PedidoServiceTest {

	private PedidoService pedidoService;

	@Mock
	private Pedidos pedidos;

	@Mock
	private NotificadorEmail notificadorEmail;

	@Mock
	private NotificadorSms notificadorSms;

	Pedido pedido;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		pedidoService = new PedidoService(pedidos, Arrays.asList(pedidos, notificadorEmail, notificadorSms));
		pedido = Pedido.builder().comValor(100.0).para("Nome", "email", "Telefone").build();
	}

	@DisplayName("Deve calcular o imposto")
	@Test
	void deveCalculaOImposto() throws Exception {
		assertEquals(10.0, pedidoService.lancar(pedido), 0.0001);
	}

	@DisplayName("Deve salvar no banco de dados")
	@Test
	void deveSalvarPedidoNoBancoDeDados() throws Exception {

		pedidoService.lancar(pedido);

		Mockito.verify(pedidos).executar(pedido);
	}

	@DisplayName("Deve notificar por e-mail")
	@Test
	void deveNotificarPorEmail() throws Exception {
		pedidoService.lancar(pedido);

		Mockito.verify(notificadorEmail).executar(pedido);
	}

	@DisplayName("Deve notificar por SMS")
	@Test
	void deveNotificarPorSms() throws Exception {
		pedidoService.lancar(pedido);

		Mockito.verify(notificadorSms).executar(pedido);
	}

	@DisplayName("Deve pagar pedido pendente")
	@Test
	void devePagarPedidoPendente() throws Exception {

		Pedido pedidoPendente = Pedido.builder().comStatus(StatusPedido.PENDENTE).build();

		when(pedidos.buscarPeloId(1L)).thenReturn(pedidoPendente);

		Pedido pedidoPago = pedidoService.pagar(1L);

		assertEquals(StatusPedido.PAGO, pedidoPago.getStatus());
	}

	@DisplayName("Deve negar pagamento")
	@Test
	void deveNegarPagamento() throws Exception {
		Pedido pedido = Pedido.builder().comStatus(StatusPedido.PAGO).build();

		when(pedidos.buscarPeloId(1L)).thenReturn(pedido);

		assertThrows(StatusPedidoInvalidoException.class, () -> pedidoService.pagar(1L));
	}
}

