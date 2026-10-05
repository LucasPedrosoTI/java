package contas.ContaPoupanca;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import contas.Conta.Conta;

public class ContaPoupanca extends Conta {
  DecimalFormat df = new DecimalFormat("###.##");

  @Override
  public String rendimento() {
    double result = this.saldo.multiply(new BigDecimal(0.05)).doubleValue();
    this.rendimento = new BigDecimal(result);

    return df.format(result);
  }

  @Override
  public String calcularImposto() {
    double result = this.rendimento.multiply(new BigDecimal(0.25)).doubleValue();

    return df.format(result);
  }

}