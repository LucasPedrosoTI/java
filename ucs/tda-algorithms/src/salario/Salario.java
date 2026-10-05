package salario;

import java.util.Scanner;

public class Salario {
  public static void main() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o código o cargo (1 ou 2)");
    int codigoCargo = sc.nextInt();

    if (codigoCargo != 1 || codigoCargo != 2) {
      System.err.println("Código inválido. Deve ser 1 ou 2.");
      sc.close();
      return;
    }

    System.out.println("Digite o salário atual");
    double salarioAtual = sc.nextDouble();

    String cargo = codigoCargo == 1 ? "Caixa" : "Gerente";
    double novoSalario = calcularAumento(codigoCargo, salarioAtual);

    System.out.println("Cargo: " + cargo);
    System.out.println("Salário atual: " + salarioAtual);
    System.out.println("Novo salário: " + novoSalario);

    sc.close();
  }

  public static double calcularAumento(int codigoCargo, double salario) {
    if (codigoCargo == 1) {
      return salario * 1.2;
    } else {
      return salario * 1.1;
    }
  }
}
