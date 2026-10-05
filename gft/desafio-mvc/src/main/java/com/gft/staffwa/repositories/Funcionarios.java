package com.gft.staffwa.repositories;

import java.util.Date;
import java.util.List;

import com.gft.staffwa.models.Funcionario;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Funcionarios extends JpaRepository<Funcionario, Long> {

  public List<Funcionario> findByAlocacaoIsNull();

  public Long countByAlocacaoIsNull();

  public Long countByAlocacaoIsNotNull();

  public Long countByDataDeAlocacaoAfter(Date data);

  @Query("select f.terminoWa, count(f.terminoWa) from Funcionario f " + "where f.alocacao is null "
      + "group by f.terminoWa order by f.terminoWa asc ")
  public List<Object[]> groupAndCountByTerminoWa();

  public List<Funcionario> findByNomeContainingAndAlocacaoIsNull(String nomeFuncionario, Pageable pageable);

  public List<Funcionario> findByNomeContainingAndAlocacaoIsNotNull(String nomeFuncionario, Pageable pageable);

}
