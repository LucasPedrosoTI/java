package com.gft.staffwa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "unidades_gft")
public class UnidadeGFT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@NotBlank(message = "CEP é obrigatório")
	private String cep;

	@NotBlank(message = "Cidade é obrigatório")
	private String cidade;

	@NotBlank(message = "Endereco é obrigatório")
	private String endereco;

	@NotBlank(message = "Estado é obrigatório")
	@Size(min = 2, max = 2, message = "Utilizar UF de 2 caracteres")
	private String estado;

	@NotBlank(message = "Telefone é obrigatório")
	private String telefone;

	@ToString.Exclude
	@OneToMany(mappedBy = "alocacao")
	private List<Funcionario> funcionarios;

}
