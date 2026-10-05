package pessoa;

import java.util.Objects;

public class Pessoa {
  private String nome;
  private String endereco;
  private String telefone;

  public Pessoa() {
  }

  public Pessoa(String nome, String endereco, String telefone) {
    this.nome = nome;
    this.endereco = endereco;
    this.telefone = telefone;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public Pessoa nome(String nome) {
    this.nome = nome;
    return this;
  }

  public Pessoa endereco(String endereco) {
    this.endereco = endereco;
    return this;
  }

  public Pessoa telefone(String telefone) {
    this.telefone = telefone;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Pessoa)) {
      return false;
    }
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(nome, pessoa.nome) && Objects.equals(endereco, pessoa.endereco)
        && Objects.equals(telefone, pessoa.telefone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, endereco, telefone);
  }

  @Override
  public String toString() {
    return "{" + " nome='" + getNome() + "'" + ", endereco='" + getEndereco() + "'" + ", telefone='" + getTelefone()
        + "'" + "}";
  }

}