package contas.Conta;

import java.math.BigDecimal;

import contas.imposto.Imposto;

public abstract class Conta implements Imposto {
  protected Long numero;
  protected String titular;
  protected BigDecimal saldo;
  protected BigDecimal rendimento;

  protected abstract String rendimento();

  public abstract String calcularImposto();

  public Long getNumero() {
    return this.numero;
  }

  public void setNumero(Long numero) {
    this.numero = numero;
  }

  public String getTitular() {
    return this.titular;
  }

  public void setTitular(String titular) {
    this.titular = titular;
  }

  public BigDecimal getSaldo() {
    return this.saldo;
  }

  public void setSaldo(BigDecimal saldo) {
    this.saldo = saldo;
  }
}