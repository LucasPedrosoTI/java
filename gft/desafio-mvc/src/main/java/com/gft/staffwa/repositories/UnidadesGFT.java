package com.gft.staffwa.repositories;

import com.gft.staffwa.models.UnidadeGFT;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadesGFT extends JpaRepository<UnidadeGFT, Long> {

  public UnidadeGFT findByNome(String nome);
}
