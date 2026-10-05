package triangulo;

import java.util.Scanner;

public class Triangulo {
  double base, altura, area;

  public void setData() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Informe a base:");
    this.base = sc.nextDouble();

    System.out.println("Informe a altura:");
    this.altura = sc.nextDouble();

    this.area = base * altura;

    sc.close();
  }

  public void getArea() {
    System.out.println("A área é: " + this.area);
  }
}
