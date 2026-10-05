import ContaCorrente.*;
import ContaPoupanca.ContaPoupanca;

public class App {
    public static void main(String[] args) throws Exception {

        // Instanciando uma classe => Objeto

        Carro uno = new Carro();
        uno.ligar();

        uno.freio = false;

        uno.trocarMarcha();

        uno.acelerar(30);

        ContaCorrente cc = new ContaCorrente();
        cc.depositar(100);
        cc.sacar(50);

        cc.verSaldo();

        ContaPoupanca cp = new ContaPoupanca();

        cp.depositar(100);
        cp.sacar(50);

        cp.verSaldo();

        int[] numeros = { 1, 2, 3, 4 };

        for (int n : numeros) {
            System.out.println(n);
        }

    }
}
