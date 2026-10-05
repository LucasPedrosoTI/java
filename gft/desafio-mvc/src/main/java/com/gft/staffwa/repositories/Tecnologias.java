package com.gft.staffwa.repositories;

import com.gft.staffwa.models.Tecnologia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Tecnologias extends JpaRepository<Tecnologia, Long> {

  public Tecnologia findByNome(String nome);
}
