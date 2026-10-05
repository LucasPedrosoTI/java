package com.gft.staffwa.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Matricula é obrigatório")
	@Column(unique = true)
	private String matricula;

	@NotBlank(message = "Nome é obrigatório")
	private String nome;

	@Enumerated(EnumType.STRING)
	private EnumCargo cargo;

	@NotNull(message = "Data de início é obrigatório")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date inicioWa;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date terminoWa;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataDeAlocacao;

	@ManyToMany
	@JoinTable(name = "funcionario_tecnologia", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "tecnologia_id"))
	private List<Tecnologia> tecnologias;

	@ManyToOne
	@JoinColumn(name = "local_de_trabalho_id")
	private UnidadeGFT localDeTrabalho;

	@ManyToOne
	@JoinColumn(name = "alocacao_id")
	private Vaga alocacao;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private Level level;

}
