package pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pesquisa {
  public static void main(String[] args) throws Exception {
    ArrayList<Integer> idades = new ArrayList<Integer>();
    ArrayList<Double> salariosHomens = new ArrayList<Double>();
    ArrayList<Double> salariosMulheres = new ArrayList<Double>();
    Scanner sc = new Scanner(System.in);
    int qtdMulheresSalariosAbaixo600 = 0;

    System.out.println("Quantos habitantes foram entrevistados?");
    int qtdEntrevistados = sc.nextInt();

    for (int i = 1; i <= qtdEntrevistados; i++) {
      System.out.println("Digite a idade do " + i + "º entrevistado(a)");

      int idade = sc.nextInt();

      if (idade <= 0 || idade >= 120) {
        sc.close();
        throw new Exception("Idade deve ser maior que 0 e menor que 120");
      }

      idades.add(idade);

      System.out.println("Digite o sexo (M/F):");
      String sexo = sc.next();

      sexo = sexo.toLowerCase().trim();

      if (!sexo.equals("m") && !sexo.equals("f")) {
        sc.close();
        throw new Exception("Sexo deve ser M ou F");
      }

      System.out.println("Informe o salário:");
      double salario = sc.nextDouble();

      if (sexo.equals("m")) {
        salariosHomens.add(salario);
      } else {
        if (salario < 600) {
          qtdMulheresSalariosAbaixo600++;
        }
        salariosMulheres.add(salario);
      }
    }

    List<Double> idadesToDouble = idades.stream().map(idade -> Double.valueOf(idade)).collect(Collectors.toList());

    System.out.println("Média de idade do grupo: " + calcularMedia(idadesToDouble));
    System.out.println("Média de salários dos homens: " + calcularMedia(salariosHomens));
    System.out.println("Quantidade de mulheres com salário abaixo de 600: " + qtdMulheresSalariosAbaixo600);
    sc.close();
  }

  public static double calcularMedia(List<Double> lista) {
    double total = 0;

    for (double item : lista) {
      total += item;
    }

    return total / lista.size();
  }

}
