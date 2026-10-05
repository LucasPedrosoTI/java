package com.gft.staffwa.repositories;

import com.gft.staffwa.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<Usuario, Long> {

  public Usuario findByEmail(String email);

}