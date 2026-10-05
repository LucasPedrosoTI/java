package ContaCorrente;

import Conta.Conta;

public final class ContaCorrente extends Conta {

  @Override
  protected void taxa() {
    this.saldo -= 1;
  }

  // override método sacar
  @Override
  public void sacar(final double valor) {
    super.sacar(valor);
    this.taxa();
  }

}