package com.gft.staffwa.services;

import java.util.List;

import com.gft.staffwa.models.Tecnologia;
import com.gft.staffwa.repositories.Tecnologias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService {

  @Autowired
  Tecnologias tecnologias;

  public List<Tecnologia> findAll() {
    return tecnologias.findAll();
  }

  public void salvar(Tecnologia tecnologia) {
    try {
      tecnologias.save(tecnologia);
    } catch (Exception e) {
      throw new IllegalArgumentException(e.getMessage());
    }
  }

  public void deletar(Long id) {
    tecnologias.deleteById(id);
  }

}
