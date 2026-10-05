package com.poo.conta.model;

import java.time.LocalDate;

public class Poupanca extends Conta {
	
	private LocalDate diaDeAniversario;

	public Poupanca() {
	}

    public Poupanca(String conta, String nome, Double saldo, LocalDate diaDeAniversario) {
		super(conta, nome, saldo);
		this.diaDeAniversario = diaDeAniversario;
	}

	public LocalDate getDiaDeAniversario() {
		return diaDeAniversario;
	}

	public void setDiaDeAniversario(LocalDate diaDeAniversario) {
		this.diaDeAniversario = diaDeAniversario;
	}
	
	
	

}
