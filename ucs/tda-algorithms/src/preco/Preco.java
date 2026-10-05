package preco;

import java.util.Scanner;

public class Preco {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o preço atual do produto");
    double precoAtual = sc.nextDouble();

    System.out.println("Digite a venda média mensal");
    double mediaMensal = sc.nextDouble();

    double novoPreco = calcularNovoPreco(precoAtual, mediaMensal);

    System.out.println("Novo preço: " + novoPreco);
    sc.close();
  }

  public static double calcularNovoPreco(double precoAtual, double mediaMensal) {
    if (mediaMensal < 500 && precoAtual < 30) {
      return precoAtual * 1.1;
    } else if ((mediaMensal >= 500 && mediaMensal < 1200) && (precoAtual >= 30 && precoAtual < 80)) {
      return precoAtual * 1.15;
    } else {
      return precoAtual * 0.8;
    }
  }
}
