package carro;

import java.util.Scanner;

public class Carro {
  public static void setData() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o km inicial");
    double kmInicial = sc.nextDouble();

    System.out.println("Digite o km final");
    double kmFinal = sc.nextDouble();

    System.out.println("Digite a quantidade de litros gastos");
    double litrosGastos = sc.nextDouble();

    System.out.println("Digite preço do litro");
    double precoLitro = sc.nextDouble();

    calcularConsumo(kmInicial, kmFinal, litrosGastos, precoLitro);
    sc.close();
  }

  public static void calcularConsumo(double kmInicial, double kmFinal, double litrosGastos, double precoLitro) {
    double distanciaPercorrida = kmFinal - kmInicial;
    double consumoMedio = litrosGastos / distanciaPercorrida;
    double valorGasto = precoLitro * litrosGastos;

    System.out.println("Distância percorrida: " + distanciaPercorrida);
    System.out.println("Consumo médio (l / km): " + consumoMedio);
    System.out.println("Valor gasto: " + valorGasto);
  }
}
