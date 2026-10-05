package com.gft.staffwa.controllers;

import com.gft.staffwa.services.FuncionarioService;
import com.gft.staffwa.services.VagaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AppController {

  @Autowired
  FuncionarioService funcionarioService;

  @Autowired
  VagaService vagaService;

  @GetMapping
  public ModelAndView renderInicio() {
    var mv = new ModelAndView("Inicio");

    Long qtdFuncionariosEmWA = funcionarioService.countByAlocacaoIsNull();
    Long qtdVagas = vagaService.countByQtdVagasGreaterThan(0);
    Long qtsAlocados7Dias = funcionarioService.countByDataDeAlocacaoAfter();

    mv.addObject("qtdFuncionariosEmWA", qtdFuncionariosEmWA);
    mv.addObject("qtdVagas", qtdVagas);
    mv.addObject("qtsAlocados7Dias", qtsAlocados7Dias);
    mv.addObject("menuInicio", true);
    return mv;
  }

  // @ModelAttribute("inicio")
  // public String inicio() {
  // return "inicio";
  // }
}
