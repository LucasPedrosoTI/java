package com.gft.staffwa.services;

import java.util.Date;

import com.gft.staffwa.models.Funcionario;
import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Funcionarios;
import com.gft.staffwa.repositories.Vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlocacaoService {

  @Autowired
  Funcionarios funcionarios;

  @Autowired
  Vagas vagas;

  public void alocarFuncionarioEmVaga(Funcionario funcionario, Vaga vaga) throws Exception {
    try {

      funcionario.setAlocacao(vaga);
      funcionario.setDataDeAlocacao(new Date());
      vaga.setQtdVagas(vaga.getQtdVagas() - 1);

      funcionarios.save(funcionario);
      vagas.save(vaga);

    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }

  }

}
