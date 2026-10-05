package ContaPoupanca;

import Conta.*;

public final class ContaPoupanca extends Conta {
  public void depositar(double valor) {
    this.taxa();
    this.saldo += valor;
  }

  @Override
  protected void taxa() {
    this.saldo += 1;
  }
}