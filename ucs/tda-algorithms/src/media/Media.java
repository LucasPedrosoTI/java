package media;

import java.util.Scanner;

public class Media {
  public static void getMedia() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite o nome do aluno");
    String aluno = sc.nextLine();

    System.out.println("Digite a primeira nota");
    double nota1 = sc.nextDouble();

    System.out.println("Digite a segunda nota");
    double nota2 = sc.nextDouble();

    System.out.println("Digite a terceira nota");
    double nota3 = sc.nextDouble();

    System.out.println("Digite a quarta nota");
    double nota4 = sc.nextDouble();

    double media = (nota1 + nota2 + nota3 + nota4) / 4;

    System.out.println("A média do aluno " + aluno + " é " + media);

    sc.close();
  }
}
