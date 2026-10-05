/**
 * Obter um número e calcular seu triplo
 */
package triple;

import java.util.Scanner;

public class Triple {
  public static void getTriple() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite um número real:");

    int num = scanner.nextInt();

    int triple = num * 3;

    System.out.println("O triplo de " + num + " é " + triple);
    scanner.close();
  }
}
