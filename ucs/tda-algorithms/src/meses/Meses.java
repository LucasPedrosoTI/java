package meses;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Meses {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new InputStreamReader(System.in, "UTF-8"));

    System.out.println("Digite um mês");
    String mes = sc.nextLine();

    switch (mes.toLowerCase()) {
      case "dezembro":
      case "janeiro":
      case "fevereiro":
        System.out.println("Verão");
        break;
      case "março":
      case "abril":
      case "maio":
        System.out.println("Outono");
        break;
      case "junho":
      case "julho":
      case "agosto":
        System.out.println("Inverno");
        break;
      case "setembro":
      case "outubro":
      case "novembro":
        System.out.println("Primavera");
        break;
      default:
        System.out.println("mês inexistente");
        break;
    }
    sc.close();
  }
}
