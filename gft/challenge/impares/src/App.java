
/**
 * GFT START_UNI - DESAFIO 1
 * Objetivo: Printar números impares no intervalo fornecido
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Forneça o número inicial: ");
            int initialNumber = scan.nextInt();
            System.out.print("Forneça o número final: ");
            int finalNumber = scan.nextInt();

            if (initialNumber < 0) {
                throw new IllegalArgumentException("Número inicial deve ser maior que 0");
            }

            if (finalNumber < initialNumber) {
                throw new IllegalArgumentException("Número final deve ser maior que o inicial");
            }

            List<Integer> oddNumbers = new ArrayList<Integer>();

            for (int number = initialNumber; number <= finalNumber; number++) {
                if (number % 2 != 0) {
                    oddNumbers.add(number);
                }
            }
            System.out.println("==============================================");
            System.out.println("Os números ímpares no intervalo fornecido são:");
            for (Integer number : oddNumbers) {
                System.out.print(number + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
