package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.UnidadeGFT;
import com.gft.staffwa.repositories.UnidadesGFT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeGftService {

  @Autowired
  UnidadesGFT unidadesGft;

  public UnidadeGFT findOneByNomeUnidade(String nome) {
    return unidadesGft.findByNome(nome);
  }

  public List<UnidadeGFT> findAll() {
    return unidadesGft.findAll();
  }

  public void salvar(UnidadeGFT unidadeGft) {
    try {
      unidadesGft.save(unidadeGft);
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  public void deletar(Long id) {
  }
}
