package notas;

import java.util.ArrayList;
import java.util.Scanner;

public class Notas {
  public static void main(String[] args) throws Exception {
    ArrayList<Double> notas = new ArrayList<Double>();
    Scanner sc = new Scanner(System.in);
    int alunosAprovados = 0;

    for (int i = 1; i < 81; i++) {
      System.out.println("Digite a nota do " + i + "º aluno(a)");

      double nota = sc.nextDouble();

      if (nota >= 6) {
        alunosAprovados++;
      }

      notas.add(nota);
    }

    System.out.println("Alunos aprovados: " + alunosAprovados);
    System.out.println("Média da turma: " + calcularMedia(notas));

    sc.close();
  }

  public static double calcularMedia(ArrayList<Double> notas) {
    double totalNotas = 0;

    for (Double nota : notas) {
      totalNotas += nota;
    }

    return totalNotas / notas.size();
  }
}
