package horasMinutos;

import java.util.Scanner;

public class HorasMinutos {
  public static void horasEmMinutos() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Digite a hora");
    double horas = sc.nextDouble();

    System.out.println("Digite os minutos");
    double minutos = sc.nextDouble();

    double totalEmMinutos = (horas * 60) + minutos;

    System.out.println("Total em minutos: " + totalEmMinutos);

    sc.close();
  }
}
