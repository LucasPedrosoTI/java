import java.math.BigDecimal;

import contas.ContaCorrente.ContaCorrente;
import contas.ContaPoupanca.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {

        // Instanciando uma classe => Objeto

        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo(new BigDecimal(1000));

        ContaPoupanca cp = new ContaPoupanca();
        cp.setSaldo(new BigDecimal(1000));

        System.out.println("Rendimento Conta corrente: " + cc.rendimento());
        System.out.println("Rendimento Conta poupança: " + cp.rendimento());
        System.out.println("Imposto Conta corrente: " + cc.calcularImposto());
        System.out.println("Imposto Conta poupança: " + cp.calcularImposto());
    }
}
