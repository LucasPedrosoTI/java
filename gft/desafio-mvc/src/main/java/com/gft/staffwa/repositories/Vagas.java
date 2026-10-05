package com.gft.staffwa.repositories;

import java.util.List;

import com.gft.staffwa.models.Vaga;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Vagas extends JpaRepository<Vaga, Long> {

  @Query("select v from Vaga v where v.qtdVagas > 0 and (v.descricaoVaga like %?1% or v.projeto like %?1%)")
  public List<Vaga> findVagasAndFilter(String descricaoVaga, Pageable pageable);

  public Long countByQtdVagasGreaterThan(int num);

  public List<Vaga> findByQtdVagasGreaterThan(int num);

  @Query("select v.dataDeAbertura, count(v.dataDeAbertura) from Vaga v "
      + "group by v.dataDeAbertura order by v.dataDeAbertura asc ")
  public List<Object[]> groupAndCountByData();
}
