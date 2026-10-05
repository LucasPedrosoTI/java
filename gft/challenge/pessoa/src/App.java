import java.util.ArrayList;
import java.util.List;

import pessoa.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        // Com construtor
        Pessoa pessoaUm = new Pessoa("Lucas", "Rua 1, São Paulo, SP", "11912345678");

        // Sem construtor
        Pessoa pessoaDois = new Pessoa();
        pessoaDois.setNome("Jane Doe");
        pessoaDois.setEndereco("Wall St, Manhattan, NY");
        pessoaDois.setTelefone("+1299342123");

        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoaUm);
        pessoas.add(pessoaDois);

        System.out.println("Lista de Pessoas:\n");
        for (Pessoa pessoa : pessoas) {
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Endereço: " + pessoa.getEndereco());
            System.out.println("Telefone: " + pessoa.getTelefone());
            System.out.println("=================================");
        }
    }
}
