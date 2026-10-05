package com.poo.conta.model;

abstract class Conta {
	private String conta;
	private String nome;
    private Double saldo;
	
	public Conta() {
	}
	
    public Conta(String conta, String nome, Double saldo) {
		super();
		this.conta = conta;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public void depositar(Double valor) {
            this.saldo += valor;
	}
	
	public void sacar(Double valor) {
            this.saldo -= valor;
	}

	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
    public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
            this.saldo = saldo;
	}
	
	
}
