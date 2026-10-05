package Conta;

import javax.swing.JOptionPane;

public abstract class Conta {
  protected double saldo;
  public int conta;

  public void sacar(double valor) {
    if (this.saldo >= valor) {
      this.saldo -= valor;
    } else {
      System.err.println("Saldo insuficiente");
    }
  }

  public void depositar(double valor) {
    this.saldo += valor;

  }

  protected abstract void taxa();

  public void verSaldo() {

    JOptionPane.showMessageDialog(null, "O saldo é " + this.saldo);

  }
}