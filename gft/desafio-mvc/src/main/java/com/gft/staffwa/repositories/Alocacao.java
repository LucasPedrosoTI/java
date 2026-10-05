package com.gft.staffwa.repositories;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.models.Vaga;

import lombok.Data;

@Data
public class Alocacao {

  private Funcionario funcionario;
  private Vaga vaga;
}
