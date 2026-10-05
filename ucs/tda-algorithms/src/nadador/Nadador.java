package nadador;

import java.util.Scanner;

public class Nadador {
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    String[] categorias = { "Infantil A", "Infantil B", "Juvenil A", "Juvenil B", "Adulto" };

    System.out.println("Digite a idade do nadador");
    int idade = sc.nextInt();

    if (idade >= 5 && idade <= 7) {
      System.err.println(categorias[0]);
    } else if (idade >= 8 && idade <= 10) {
      System.err.println(categorias[1]);
    } else if (idade >= 11 && idade <= 13) {
      System.err.println(categorias[2]);
    } else if (idade >= 14 && idade <= 17) {
      System.err.println(categorias[3]);
    } else {
      System.err.println(categorias[4]);
    }

    sc.close();
  }
}
