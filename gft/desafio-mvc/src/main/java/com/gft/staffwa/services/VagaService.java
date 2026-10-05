package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.Vaga;
import com.gft.staffwa.repositories.Filter;
import com.gft.staffwa.repositories.Vagas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

  @Autowired
  Vagas vagas;

  public List<Vaga> filtrar(Filter filtro, Pageable pageable) {
    final String descricaoVaga = (filtro).getBusca() == null ? "" : filtro.getBusca();
    return this.vagas.findVagasAndFilter(descricaoVaga, pageable);
  }

  public void salvar(Vaga vaga) {
    try {
      this.vagas.save(vaga);
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Código já registrado");
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  public Long countByQtdVagasGreaterThan(int num) {
    return vagas.countByQtdVagasGreaterThan(num);
  }

  public void deletar(Vaga vaga) {

    Vaga vagaTarget = vagas.getOne(vaga.getId());

    vagaTarget.setQtdVagas(0);

    vagas.save(vagaTarget);

  }

  public List<Object[]> groupAndCountByData() {
    return vagas.groupAndCountByData();
  }

}
