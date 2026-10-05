package com.gft.model;

public class Pedido {

	private double valor;
	private Cliente cliente;
	private StatusPedido status;

	private Pedido(Builder builder) {
		this.valor = builder.valor;
		this.cliente = builder.cliente;
		this.status = builder.status;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private StatusPedido status;
		private double valor;
		private Cliente cliente;

		private Builder() {}

		public Builder comValor(double valor) {
			this.valor = valor;
			return this;
		}

		public Builder para(String nome, String email, String telefone) {
			this.cliente = new Cliente(nome, email, telefone);
			return this;
		}

		public Builder comStatus(StatusPedido status) {
			this.status = status;
			return this;
		}

		public Pedido build() {
			return new Pedido(this);
		}
	}

	@Override
	public String toString() {
		return "Pedido [valor=" + valor + ", cliente=" + cliente + "]";
	}

}
