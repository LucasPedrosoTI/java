package com.gft.staffwa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Level {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @NotBlank(message = "nome é obrigatório")
  private EnumLevel nome;

  @OneToMany(mappedBy = "level")
  @ToString.Exclude
  List<Funcionario> funcionarios;

  @OneToMany(mappedBy = "level")
  @ToString.Exclude
  List<Vaga> vagas;

}
