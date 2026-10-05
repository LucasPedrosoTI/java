/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.gft.staffwa.models;

/**
 *
 * @author lps10
 */

public enum EnumCargo {
  ANALISTA_DE_SISTEMAS("Analista de Sistemas"), DESENVOLVEDOR_FRONT("Desenvolvedor Front End"),
  DESENVOLVEDOR_BACK("Desenvolvedor Back End"), DESENVOLVEDOR_FULL("Desenvolvedor Full Stack"),
  ESTAGIARIO("Estagiário"), ENGENHEIRO_SOFTWARE("Engenheiro de Software"), ANALISTA_TESTES("Analista de Testes"),
  ARQUITETO_SOFTWARE("Arquiteto de Software"), GESTOR_PROJETOS("Gestor de Projetos"), SCRUM_MASTER("Scrum Master"),
  UX_DESIGNER("UX Designer"), ANALISTA_NEGOCIOS("Analista de Negocios"), PROJECT_OWNER("Project Owner"),
  QUALITY_ASSURANCE("Quality Assurance"), TECH_LEAD("Tech Lead");

  private final String descricao;

  private EnumCargo(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

}
