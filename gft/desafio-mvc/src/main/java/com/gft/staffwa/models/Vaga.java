package com.gft.staffwa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Data de abertura é obrigatória")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataDeAbertura;

	@NotBlank(message = "Código da vaga é obrigatório")
	@Column(unique = true)
	private String codigoVaga;

	@NotBlank(message = "Descrição é obrigatório")
	private String descricaoVaga;

	@NotBlank(message = "Projeto é obrigatório")
	private String projeto;

	@NotNull(message = "Quantidade de vagas é obrigatório")
	@Min(value = 0, message = "A quantidade não pode ser negativa")
	@Max(value = 999999999, message = "Valor não pode ser maior que 9999999999")
	private Integer qtdVagas;

	@ToString.Exclude
	@ManyToMany
	@JoinTable(name = "vaga_tecnologia", joinColumns = @JoinColumn(name = "vaga_id"), inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
	private List<Tecnologia> tecnologias;

	@ToString.Exclude
	@OneToMany(mappedBy = "alocacao")
	private List<Funcionario> funcionarios;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private Level level;
}
